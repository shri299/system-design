package airportterminalmanagement.repository;

import airportterminalmanagement.Gate;
import airportterminalmanagement.interfaces.GateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;

public class InMemoryGateRepo implements GateRepository {
    private final ConcurrentMap<String, Gate> map = new ConcurrentHashMap<>();
    public Optional<Gate> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public void save(Gate g) { map.put(g.id, g); }
    public List<Gate> findAll(Predicate<Gate> filter) {
        List<Gate> res = new ArrayList<>();
        for (Gate g : map.values()) if (filter.test(g)) res.add(g);
        return res;
    }
}
