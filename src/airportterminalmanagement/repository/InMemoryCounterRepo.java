package airportterminalmanagement.repository;

import airportterminalmanagement.CheckInCounter;
import airportterminalmanagement.interfaces.CounterRepository;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Predicate;

public class InMemoryCounterRepo implements CounterRepository {
    private final ConcurrentMap<String, CheckInCounter> map = new ConcurrentHashMap<>();
    public Optional<CheckInCounter> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public void save(CheckInCounter c) { map.put(c.id, c); }
    public List<CheckInCounter> findAll(Predicate<CheckInCounter> filter) {
        List<CheckInCounter> res = new ArrayList<>();
        for (CheckInCounter c : map.values()) if (filter.test(c)) res.add(c);
        return res;
    }
}
