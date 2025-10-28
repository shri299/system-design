package airportterminalmanagement;

import airportterminalmanagement.interfaces.DomainEvent;

public class GateAllocated implements DomainEvent {
    final String flightId;
    final String gateId;
    GateAllocated(String f, String g){ this.flightId = f; this.gateId = g; }
}
