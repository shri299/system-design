package airportterminalmanagement.repository;

import airportterminalmanagement.BaggageBelt;
import airportterminalmanagement.interfaces.BeltRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;

public class InMemoryBeltRepo implements BeltRepository {
    private final ConcurrentMap<String, BaggageBelt> map = new ConcurrentHashMap<>();
    public Optional<BaggageBelt> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public void save(BaggageBelt b) { map.put(b.id, b); }
    public List<BaggageBelt> findAll(Predicate<BaggageBelt> filter) {
        List<BaggageBelt> res = new ArrayList<>();
        for (BaggageBelt b : map.values()) if (filter.test(b)) res.add(b);
        return res;
    }
}
