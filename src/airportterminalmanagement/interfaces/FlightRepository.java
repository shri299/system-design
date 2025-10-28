package airportterminalmanagement.interfaces;

import airportterminalmanagement.Flight;

import java.util.*;
import java.util.function.Predicate;

public interface FlightRepository {
    Optional<Flight> findById(String id);
    void save(Flight f);
    List<Flight> findAll(Predicate<Flight> filter);
}
