package airportterminalmanagement;

import airportterminalmanagement.interfaces.DomainEvent;
import airportterminalmanagement.interfaces.EventBus;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimpleEventBus implements EventBus {

    private final ConcurrentMap<Class<?>, CopyOnWriteArrayList<EventListener>> listeners = new ConcurrentHashMap<>();
    public void publish(DomainEvent event) {
        List<EventListener> ls = listeners.getOrDefault(event.getClass(), new CopyOnWriteArrayList<>());
        for (EventListener l : ls) l.onEvent(event);
    }
    public void subscribe(Class<? extends DomainEvent> type, EventListener listener) {
        listeners.computeIfAbsent(type, k -> new CopyOnWriteArrayList<>()).add(listener);
    }
}
