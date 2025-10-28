package airportterminalmanagement;

import airportterminalmanagement.enums.ResourceState;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Resource {

    public final String id;
    public final String terminalId;
    volatile ResourceState state = ResourceState.FREE;
    // Lock per resource for precise control if needed
    final Lock lock = new ReentrantLock(true);
    Resource(String id, String terminalId) { this.id = id; this.terminalId = terminalId; }
}
