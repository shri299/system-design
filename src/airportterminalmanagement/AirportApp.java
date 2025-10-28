package airportterminalmanagement;

import airportterminalmanagement.enums.FlightType;
import airportterminalmanagement.interfaces.*;
import airportterminalmanagement.repository.InMemoryBeltRepo;
import airportterminalmanagement.repository.InMemoryCounterRepo;
import airportterminalmanagement.repository.InMemoryFlightRepo;
import airportterminalmanagement.repository.InMemoryGateRepo;

import java.time.Instant;
import java.util.*;

public class AirportApp {

    public static void main(String[] args) {
        EventBus bus = new SimpleEventBus();
        bus.subscribe(GateAllocated.class, e -> {
            GateAllocated ev = (GateAllocated) e;
            System.out.println("[EVENT] Gate allocated: flight=" + ev.flightId + " gate=" + ev.gateId);
        });

        FlightRepository flightRepo = new InMemoryFlightRepo();
        GateRepository gateRepo = new InMemoryGateRepo();
        CounterRepository counterRepo = new InMemoryCounterRepo();
        BeltRepository beltRepo = new InMemoryBeltRepo();

        // Seed sample resources
        gateRepo.save(new Gate("G1", "T1", EnumSet.of(FlightType.ARRIVAL, FlightType.DEPARTURE)));
        gateRepo.save(new Gate("G2", "T1", EnumSet.of(FlightType.DEPARTURE)));
        counterRepo.save(new CheckInCounter("C1", "T1"));
        counterRepo.save(new CheckInCounter("C2", "T1"));
        beltRepo.save(new BaggageBelt("B1", "T1"));

        FlightService flightService = new FlightService(flightRepo, bus);
        ResourceAllocator allocator = new ResourceAllocator(flightRepo, gateRepo, counterRepo, beltRepo,
                new SimpleGateSelectionPolicy(), bus);

        Flight f = flightService.schedule("F-1001", "AI", "AI302", FlightType.DEPARTURE, Instant.now().plusSeconds(3600), "T1");
        String gateId = allocator.allocateGate(f.id);
        System.out.println("Allocated gate: " + gateId);
        List<String> counters = allocator.allocateCounters(f.id, 2);
        System.out.println("Allocated counters: " + counters);

        // Release (e.g., after pushback)
        allocator.releaseCounters(f.id);
        allocator.releaseGate(f.id);
    }
}
