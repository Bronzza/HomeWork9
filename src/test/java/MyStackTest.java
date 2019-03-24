import applicationPackage.MyStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest extends MyStackTestAbstract <String> {

    @Before
    public void setUp(){
        myStack = createSampleStack();
        value = createSampleValue();
        myStack.push(value);
    }

    @Test
    public void push() {
        assertEquals(value,myStack.peek());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void pop() {
        myStack.pop();
        assertEquals(Exception.class, myStack.pop());
    }

    @Test
    public void peek() {
        myStack.peek();
        assertEquals(value, myStack.peek());
    }


    @Override
    public String createSampleValue() {
        return "String";
    }

    @Override
    public MyStack<String> createSampleStack() {
        return new MyStack<>();
    }
}