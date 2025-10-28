package airportterminalmanagement.repository;

import airportterminalmanagement.Flight;
import airportterminalmanagement.interfaces.FlightRepository;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Predicate;

public class InMemoryFlightRepo implements FlightRepository {
    private final ConcurrentMap<String, Flight> map = new ConcurrentHashMap<>();
    public Optional<Flight> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public void save(Flight f) { map.put(f.id, f); }
    public List<Flight> findAll(Predicate<Flight> filter) {
        List<Flight> res = new ArrayList<>();
        for (Flight f : map.values()) if (filter.test(f)) res.add(f);
        return res;
    }
}
