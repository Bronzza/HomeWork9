import applicationPackage.MyStack;

public abstract class MyStackTestAbstract <T> {
    protected MyStack<T> myStack;
    protected T value;

    public abstract T createSampleValue();
    public abstract MyStack<T> createSampleStack();

}