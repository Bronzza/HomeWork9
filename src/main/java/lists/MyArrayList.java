package lists;

public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int counter = 0;
    private final static int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public T get(int i) {
        if (counter / 2 < i) {
            for (int j = 0; j < array.length; j++) {
                if (j == i) {
                    return (T) array[j];
                }
            }
        } else {
            for (int j = counter; j >= 0; j--) {
                if (j == i) {
                    return (T) array[j];
                }
            }
        }
        return null;
    }

    @Override
    public void add(T t) {
        array[counter] = t;
        counter++;
        if (checkIsExpand()) {
            expandArray();
        }
    }

    public void add(int index, T t) {
        if (isValidIndexAdd(index)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == counter) {
            add(t);
        } else {
            Object[] temp = new Object[array.length];
            System.arraycopy(array, 0, temp, 0, index);
            temp[index] = t;
            System.arraycopy(array, index, temp, index + 1, counter - index);
            array = temp;
            counter++;
        }
        if (checkIsExpand()) {
            expandArray();
        }
    }

    private boolean isValidIndexAdd(int index) {
        return index < 0 || index > counter;
    }

    @Override
    public void remove(int index) {
        if (index > counter - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == counter - 1) {
            array[index] = null;
            counter--;
        } else {
            array[index] = null;
            System.arraycopy(array, index + 1, array, index, counter - index - 1);
            counter--;
        }
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < counter; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i != counter - 1) {
                sb.append(array[i] + ",");
            } else {
                sb.append(array[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean checkIsExpand() {
        return counter == array.length;
    }

    private void expandArray() {
        double expandRate;
        if (array.length == 1) {
            expandRate = 2;
        } else {
            expandRate = 1.5;
        }
        Object[] temp = new Object[(int) (array.length * expandRate)];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }
}
