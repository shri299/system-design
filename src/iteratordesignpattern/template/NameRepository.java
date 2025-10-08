package iteratordesignpattern.template;

public class NameRepository implements Container<String>{
    private String[] names = {"Robert", "John", "Julie", "Lora"};
    @Override
    public Iterator<String> getIterator() {
       return null;
    }

    @Override
    public void add(String item) {

    }

    @Override
    public void remove(String item) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
