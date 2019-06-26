package lists;

import exceptions.NoSuchValueException;

public class MyLinkedList<T> implements MyList<T> {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    private class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;
        private int size = 0;

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> prev, T value, Node<T> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public T get(int i) {
        if (checkIndex(i)) {
            return findElement(i).value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(T t) {
        if (first == null) {
            first = new Node(t);
            last = new Node(t);
            size++;
        } else {
            Node temp = last;
            Node<T> createdNode = new Node<T>(last, t, null);
            temp.next = createdNode;
            last = createdNode;
            if (first.next == null) {
                first.next = last;
            }
            size++;
        }
    }

    public void add(int index, T element) {
        if (checkIndex(index)) {
            if (index == size - 1) {
                add(element);
            } else if (index == 0) {
                addFirst(element);
            } else if (index == 1) {
                Node<T> temp = findElement(index);
                Node<T> createdNode = new Node(first, element, temp);
                temp.prev = createdNode;
                first.next = createdNode;
                size++;
            } else {
                Node indexNode = findElement(index);
                Node temp = indexNode.prev;
                Node<T> createdNode = new Node(temp, element, indexNode);
                indexNode.prev = createdNode;
                temp.next = createdNode;
                size++;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addFirst(T t) {
        Node<T> temp = first;
        Node<T> createdNode = new Node<T>(null, t, temp);
        first = createdNode;
        if (temp == null) {
            last = createdNode;
        } else {
            temp.prev = createdNode;
        }
        size++;
    }

    private T unlink(Node<T> node) {
        if (node == null) {
            throw new NoSuchValueException("No such value in the list");
        }
        T value = node.value;
        Node<T> next = node.next;
        Node<T> prev = node.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.value = null;
        size--;
        return value;
    }

    @Override
    public void remove(int i) {
        unlink(findElement(i));
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> findElement(int index) {
        if (checkIndex(index)) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean checkIndex(int i) {
        return (i >= 0 && i < size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (first == null) return "isEmpty";
        else {
            Node tmp = first;
            sb.append(tmp.value);
            while (tmp.next != null) {
                sb.append(", ");
                tmp = tmp.next;
                sb.append(tmp.value);
            }
            return sb.toString();
        }
    }
}
