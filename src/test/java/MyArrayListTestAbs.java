import java.util.List;

public  abstract  class MyArrayListTestAbs <T> {
    protected MyArrayList<T> myArrayList;
    protected List <T> normalList;
    protected T value;

    public abstract T createSampleValue();
    public abstract MyArrayList <T> createSampleMyArrayList();
    public abstract List<T> createSampleList();
    public abstract T [] dataForList(int sizeArray);
    public abstract T createRandomValue();
    public abstract void fillArray (T [] array);
    }
