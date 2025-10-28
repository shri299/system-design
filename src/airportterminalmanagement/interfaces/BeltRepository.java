package airportterminalmanagement.interfaces;

import airportterminalmanagement.BaggageBelt;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.function.Predicate;

public interface BeltRepository {
    Optional<BaggageBelt> findById(String id);
    List<BaggageBelt> findAll(Predicate<BaggageBelt> filter);
    void save(BaggageBelt b);
}
