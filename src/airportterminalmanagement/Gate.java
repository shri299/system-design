package airportterminalmanagement;

import airportterminalmanagement.enums.FlightType;

import java.util.*;

public class Gate extends Resource {
    final Set<FlightType> supportedTypes;
    Gate(String id, String terminalId, Set<FlightType> supportedTypes) {
        super(id, terminalId); this.supportedTypes = Collections.unmodifiableSet(supportedTypes);
    }
}
