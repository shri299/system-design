package airportterminalmanagement;

import airportterminalmanagement.interfaces.DomainEvent;

public class GateReleased implements DomainEvent {
    final String flightId; final String gateId;
    GateReleased(String f, String g){ this.flightId = f; this.gateId = g; }
}
