package airportterminalmanagement.interfaces;

import airportterminalmanagement.interfaces.DomainEvent;

public interface EventBus {
    void publish(DomainEvent event);
    void subscribe(Class<? extends DomainEvent> type, EventListener listener);
    interface EventListener { void onEvent(DomainEvent e); }
}
