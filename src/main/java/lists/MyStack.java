package lists;

public class MyStack<T> extends MyLinkedList<T> implements MyStackInterface <T> {
    @Override
    public T push(T element) {
        addFirst(element);
        return get(0);
    }

    @Override
    public T pop() {
        T value = get(0);
        remove(0);
        return value;
    }

    @Override
    public T peek() {
        return get(0);
    }
}
