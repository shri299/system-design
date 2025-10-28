package airportterminalmanagement;

import airportterminalmanagement.enums.FlightType;
import airportterminalmanagement.enums.ResourceState;
import airportterminalmanagement.interfaces.*;

import java.util.*;
import java.util.concurrent.locks.*;

public class ResourceAllocator {

    private final FlightRepository flights;
    private final GateRepository gates;
    private final CounterRepository counters;
    private final BeltRepository belts;
    private final GateSelectionPolicy gatePolicy;
    private final ReadWriteLock gateRWLock = new ReentrantReadWriteLock(true);
    private final ReadWriteLock counterRWLock = new ReentrantReadWriteLock(true);
    private final ReadWriteLock beltRWLock = new ReentrantReadWriteLock(true);
    private final EventBus bus;

    ResourceAllocator(FlightRepository flights, GateRepository gates,
                      CounterRepository counters, BeltRepository belts,
                      GateSelectionPolicy gatePolicy, EventBus bus) {
        this.flights = flights; this.gates = gates; this.counters = counters; this.belts = belts;
        this.gatePolicy = gatePolicy; this.bus = bus;
    }

    /** Atomic gate allocation */
    public synchronized String allocateGate(String flightId) {
        Flight f = flights.findById(flightId).orElseThrow(() -> new NoSuchElementException("Flight not found"));
        if (f.gateId != null) return f.gateId; // idempotent

        gateRWLock.writeLock().lock();
        try {
            List<Gate> candidates = gates.findAll(g -> g.terminalId.equals(f.terminalId));
            Optional<Gate> chosen = gatePolicy.chooseGate(candidates, f);
            Gate g = chosen.orElseThrow(() -> new IllegalStateException("No suitable gate available"));
            g.lock.lock();
            try {
                if (g.state != ResourceState.FREE) throw new IllegalStateException("Gate became busy");
                g.state = ResourceState.OCCUPIED;
                gates.save(g);
                f.gateId = g.id;
                flights.save(f);
            } finally {
                g.lock.unlock();
            }
            bus.publish(new GateAllocated(f.id, f.gateId));
            return f.gateId;
        } finally {
            gateRWLock.writeLock().unlock();
        }
    }

    public synchronized void releaseGate(String flightId) {
        Flight f = flights.findById(flightId).orElseThrow(() -> new NoSuchElementException("Flight not found"));
        if (f.gateId == null) return;

        gateRWLock.writeLock().lock();
        try {
            Gate g = gates.findById(f.gateId).orElseThrow(() -> new NoSuchElementException("Gate not found"));
            g.lock.lock();
            try {
                g.state = ResourceState.FREE;
                gates.save(g);
                String released = f.gateId;
                f.gateId = null;
                flights.save(f);
                bus.publish(new GateReleased(f.id, released));
            } finally {
                g.lock.unlock();
            }
        } finally {
            gateRWLock.writeLock().unlock();
        }
    }

    public List<String> allocateCounters(String flightId, int count) {
        if (count <= 0) return Collections.emptyList();
        Flight f = flights.findById(flightId).orElseThrow(() -> new NoSuchElementException("Flight not found"));

        counterRWLock.writeLock().lock();
        try {
            List<CheckInCounter> free = counters.findAll(c -> c.terminalId.equals(f.terminalId) && c.state == ResourceState.FREE);
            if (free.size() < count) throw new IllegalStateException("Not enough counters");
            List<String> assigned = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                CheckInCounter c = free.get(i);
                c.lock.lock();
                try {
                    if (c.state != ResourceState.FREE) continue; // lost race; skip
                    c.state = ResourceState.OCCUPIED;
                    counters.save(c);
                    f.counterIds.add(c.id);
                } finally {
                    c.lock.unlock();
                }
                assigned.add(c.id);
            }
            flights.save(f);
            return assigned;
        } finally {
            counterRWLock.writeLock().unlock();
        }
    }

    public void releaseCounters(String flightId) {
        Flight f = flights.findById(flightId).orElseThrow(() -> new NoSuchElementException("Flight not found"));
        if (f.counterIds.isEmpty()) return;

        counterRWLock.writeLock().lock();
        try {
            for (String id : new ArrayList<>(f.counterIds)) {
                counters.findById(id).ifPresent(c -> {
                    c.lock.lock();
                    try { c.state = ResourceState.FREE; counters.save(c); }
                    finally { c.lock.unlock(); }
                });
            }
            f.counterIds.clear();
            flights.save(f);
        } finally {
            counterRWLock.writeLock().unlock();
        }
    }

    public String allocateBelt(String flightId) {
        Flight f = flights.findById(flightId).orElseThrow(() -> new NoSuchElementException("Flight not found"));
        if (f.type != FlightType.ARRIVAL) throw new IllegalStateException("Belts only for arrivals");
        if (f.beltId != null) return f.beltId;

        beltRWLock.writeLock().lock();
        try {
            Optional<BaggageBelt> opt = belts.findAll(b -> b.terminalId.equals(f.terminalId) && b.state == ResourceState.FREE)
                    .stream().sorted(Comparator.comparing(b -> b.id)).findFirst();
            BaggageBelt b = opt.orElseThrow(() -> new IllegalStateException("No belt available"));
            b.lock.lock();
            try {
                if (b.state != ResourceState.FREE) throw new IllegalStateException("Belt became busy");
                b.state = ResourceState.OCCUPIED;
                belts.save(b);
                f.beltId = b.id;
                flights.save(f);
                return b.id;
            } finally {
                b.lock.unlock();
            }
        } finally {
            beltRWLock.writeLock().unlock();
        }
    }

    public void releaseBelt(String flightId) {
        Flight f = flights.findById(flightId).orElseThrow(() -> new NoSuchElementException("Flight not found"));
        if (f.beltId == null) return;

        beltRWLock.writeLock().lock();
        try {
            BaggageBelt b = belts.findById(f.beltId).orElseThrow(() -> new NoSuchElementException("Belt not found"));
            b.lock.lock();
            try { b.state = ResourceState.FREE; belts.save(b); f.beltId = null; flights.save(f); }
            finally { b.lock.unlock(); }
        } finally {
            beltRWLock.writeLock().unlock();
        }
    }
}
