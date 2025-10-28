package airportterminalmanagement;

import airportterminalmanagement.enums.FlightStatus;
import airportterminalmanagement.enums.FlightType;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;

public class Flight {
    public final String id;
    final String airline;
    final String number;
    final FlightType type;
    final Instant scheduledTime;
    volatile FlightStatus status;

    volatile String terminalId;
    volatile String gateId;
    volatile String beltId;
    final Set<String> counterIds = ConcurrentHashMap.newKeySet();

    Flight(String id, String airline, String number, FlightType type, Instant scheduledTime, String terminalId) {
        this.id = id; this.airline = airline; this.number = number;
        this.type = type; this.scheduledTime = scheduledTime; this.terminalId = terminalId;
        this.status = FlightStatus.SCHEDULED;
    }
}
