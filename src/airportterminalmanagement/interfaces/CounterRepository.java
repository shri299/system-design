package airportterminalmanagement.interfaces;

import airportterminalmanagement.CheckInCounter;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.function.Predicate;

public interface CounterRepository {
    Optional<CheckInCounter> findById(String id);
    List<CheckInCounter> findAll(Predicate<CheckInCounter> filter);
    void save(CheckInCounter c);
}
