package airportterminalmanagement;

import airportterminalmanagement.enums.ResourceState;
import airportterminalmanagement.interfaces.GateSelectionPolicy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SimpleGateSelectionPolicy implements GateSelectionPolicy {
    public Optional<Gate> chooseGate(List<Gate> candidates, Flight flight) {
        return candidates.stream()
                .filter(g -> g.state == ResourceState.FREE)
                .filter(g -> g.supportedTypes.contains(flight.type))
                .sorted(Comparator.comparing(g -> g.id))
                .findFirst();
    }
}
