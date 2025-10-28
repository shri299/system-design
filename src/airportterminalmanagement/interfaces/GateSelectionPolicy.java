package airportterminalmanagement.interfaces;

import airportterminalmanagement.Flight;
import airportterminalmanagement.Gate;

import java.util.List;
import java.util.Optional;

public interface GateSelectionPolicy {
    Optional<Gate> chooseGate(List<Gate> candidates, Flight flight);
}
