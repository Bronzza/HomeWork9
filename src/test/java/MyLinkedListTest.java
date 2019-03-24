import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MyLinkedListTest extends MyLinkedListTestAbstract<Integer> {

    @Rule
    public ExpectedException trown = ExpectedException.none();

    @Before
    public void setUp() {
        myLinkedList = createSampleMyLinkedList();
        normalList = createSampleList();
        value = createSampleValue();
        addDataInLists();
    }

    private void addDataInLists() {
        Stream.of(dataForList(2))
                .forEach(a -> {
                    myLinkedList.add(a);
                    normalList.add(a);
                });
        myLinkedList.add(value);
        normalList.add(value);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        assertEquals(myLinkedList.get(myLinkedList.size() - 1), normalList.get(normalList.size() - 1));
        assertEquals(myLinkedList.get(myLinkedList.size() - 1), value);
        assertEquals(Exception.class, myLinkedList.get(myLinkedList.size()));
    }

    @Test
    public void add() {
        myLinkedList.add(value);
        assertEquals(value, myLinkedList.get(myLinkedList.size() - 1));
        myLinkedList.add(null);
        assertNull(myLinkedList.get(myLinkedList.size()-1));

    }

    @Test
    public void add1() throws IndexOutOfBoundsException {
        int index = randomInt(myLinkedList.size());
        myLinkedList.add(index, value);
        assertEquals(value, myLinkedList.get(index));
        trown.expect(IndexOutOfBoundsException.class);
        myLinkedList.add(-1, value);
        trown.expect(IndexOutOfBoundsException.class);
        myLinkedList.add(myLinkedList.size()+1, value);

    }

    @Test
    public void addFirst() {
        myLinkedList.addFirst(value);
        assertEquals(value, myLinkedList.get(0));
    }

    @Test
    public void remove() throws IndexOutOfBoundsException, NullPointerException {
        int size = myLinkedList.size();
        myLinkedList.add(value);
        assertEquals(size + 1, myLinkedList.size());
        assertEquals(value, myLinkedList.get(size));
        myLinkedList.remove(size);
        assertEquals(size, myLinkedList.size());
        trown.expect(IndexOutOfBoundsException.class);
        myLinkedList.get(size);
        trown.expect(NullPointerException.class);
        myLinkedList.remove(myLinkedList.size()+1);
    }

    @Test
    public void size() {
        int size = myLinkedList.size();
        myLinkedList.add(null);
        assertEquals(size + 1, myLinkedList.size());
    }

    @After
    public void endUp() {
        System.out.println("Test is finished");
        myLinkedList = null;
        normalList = null;
        value = null;
    }

    @Override
    public Integer createSampleValue() {
        return 10;
    }

    @Override
    public MyLinkedList<Integer> createSampleMyLinkedList() {
        return new MyLinkedList<>();
    }

    @Override
    public List<Integer> createSampleList() {
        return new LinkedList<>();
    }

    @Override
    public Integer[] dataForList(int sizeArray) {
        Integer[] resultArray = new Integer[sizeArray];
        fillArray(resultArray);
        return resultArray;
    }

    @Override
    public Integer createRandomValue() {
        Random rnd = new Random();
        return rnd.nextInt(15);
    }

    @Override
    public void fillArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    private int randomInt(int limit) {
        Random rnd = new Random();
        return rnd.nextInt(limit);
    }
}
