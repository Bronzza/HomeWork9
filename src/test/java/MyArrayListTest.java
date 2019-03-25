import lists.MyArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MyArrayListTest extends MyArrayListTestAbs<Integer> {
    private int indexTest;
    private static final Integer VALUE_FOR_TESTING  = 5;

    @Before
    public void setUp() {
        myArrayList = createSampleMyArrayList();
        normalList = createSampleList();
        value = createSampleValue();
        addDataInLists();
    }

    private void addDataInLists() {
        Stream.of(dataForList(2))
                .forEach(a -> {
                    myArrayList.add(a);
                    normalList.add(a);
                });
        myArrayList.add(indexTest, value);
        normalList.add(indexTest, value);
    }

    @Test
    public void get() {
        assertEquals(myArrayList.get(indexTest), normalList.get(indexTest));
        assertEquals(myArrayList.get(indexTest), value);
        assertNull(myArrayList.get(myArrayList.size()));
    }

    @Test
    public void add() {
        myArrayList.add(value);
        assertEquals(value, myArrayList.get(myArrayList.size() - 1));
        indexTest = 1;
        myArrayList.add(indexTest, value);
        assertEquals(value, myArrayList.get(indexTest));
    }

    @Test
    public void remove() {
        int size = myArrayList.size();
        myArrayList.remove(--size);
        assertEquals(size, myArrayList.size());
    }

    @Test
    public void size() {
        int size = myArrayList.size();
        myArrayList.add(createSampleValue());
        assertEquals(size + 1, myArrayList.size());
    }

    @Override
    public Integer createSampleValue() {
        return VALUE_FOR_TESTING;
    }

    @Override
    public MyArrayList<Integer> createSampleMyArrayList() {
        return new MyArrayList<>();
    }

    @Override
    public List<Integer> createSampleList() {
        return new ArrayList<>();
    }

    @Override
    public Integer[] dataForList(int sizeArray) {
        Integer[] result = new Integer[sizeArray];
        fillArray(result);
        return result;
    }

    @Override
    public Integer createRandomValue() {
        return null;
    }

    @Override
    public void fillArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
}
