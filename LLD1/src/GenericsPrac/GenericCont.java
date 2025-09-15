package GenericsPrac;

public class GenericCont<T> implements Container<T>{
    private T item;

    @Override
    public void add(T var) {
        this.item = var;
    }

    @Override
    public T get() {
        return this.item;
    }
}
