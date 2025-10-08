package iteratordesignpattern.template;

public interface Container<T> {
    Iterator<T> getIterator();

    void add(T item);

    void remove(T item);

    int size();

    T get(int index);

    boolean isEmpty();
}
