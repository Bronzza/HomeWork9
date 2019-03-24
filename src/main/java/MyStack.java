public class MyStack<T> extends MyLinkedList implements MyStackInterface <T> {

    @Override
    public T push(T element) {
        addFirst(element);
        return (T) get(0);
    }

    @Override
    public T pop() {
        T value = (T) get(0);
        remove(0);
        return value;
    }

    @Override
    public T peek() {
        return (T) get(0);
    }

}
