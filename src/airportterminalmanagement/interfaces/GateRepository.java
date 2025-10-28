package airportterminalmanagement.interfaces;

import airportterminalmanagement.Gate;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.function.Predicate;

public interface GateRepository {
    Optional<Gate> findById(String id);
    List<Gate> findAll(Predicate<Gate> filter);
    void save(Gate g);
}
