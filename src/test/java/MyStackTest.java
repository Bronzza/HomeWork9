import lists.MyStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest extends MyStackTestAbstract<String> {
    private static final String VALUE_FOR_TESTING = "Value";
    @Before
    public void setUp() {
        int howManyElements = 3;
        myStack = createSampleStack();
        value = createSampleValue();
        for (int i = 0; i < howManyElements; i++) {
            myStack.push(value);
        }
    }

    @Test
    public void push() {
        assertEquals(value, myStack.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void pop() {
        int stackSize = myStack.size();
        for (int i = 0; i <= stackSize; i++) {
            myStack.pop();
        }
        myStack.pop();
    }

    @Test
    public void peek() {
        assertEquals(value, myStack.peek());
    }

    @Override
    public String createSampleValue() {
        return VALUE_FOR_TESTING;
    }

    @Override
    public MyStack<String> createSampleStack() {
        return new MyStack<>();
    }
}
