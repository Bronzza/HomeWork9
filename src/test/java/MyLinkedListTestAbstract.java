import lists.MyLinkedList;

import java.util.List;

public abstract class MyLinkedListTestAbstract<T>  {
    protected MyLinkedList<T> myLinkedList;
    protected List <T> normalList;
    protected T value;

    public abstract T createSampleValue();
    public abstract MyLinkedList<T> createSampleMyLinkedList();
    public abstract List<T> createSampleList();
    public abstract T [] dataForList(int sizeArray);
    public abstract T createRandomValue();
    public abstract void fillArray (T [] array);
}
