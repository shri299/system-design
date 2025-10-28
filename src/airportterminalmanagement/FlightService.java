package airportterminalmanagement;

import airportterminalmanagement.enums.FlightStatus;
import airportterminalmanagement.enums.FlightType;
import airportterminalmanagement.interfaces.EventBus;
import airportterminalmanagement.interfaces.FlightRepository;

import java.time.Instant;
import java.util.*;

public class FlightService {
    private final FlightRepository flights;
    private final EventBus bus;
    FlightService(FlightRepository flights, EventBus bus) {
        this.flights = flights; this.bus = bus;
    }
    public Flight schedule(String id, String airline, String number, FlightType type, Instant time, String terminalId) {
        Flight f = new Flight(id, airline, number, type, time, terminalId);
        flights.save(f);
        return f;
    }
    public void updateStatus(String flightId, FlightStatus status) {
        Flight f = flights.findById(flightId).orElseThrow(() -> new NoSuchElementException("Flight not found"));
        f.status = status;
        flights.save(f);
    }
}
