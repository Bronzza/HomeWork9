import lists.MyArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MyArrayListTest extends MyArrayListTestAbs<Integer> {
    private static final int INDEX_TEST = 1;
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
        myArrayList.add(INDEX_TEST, value);
        normalList.add(INDEX_TEST, value);
    }

    @Test
    public void get() {
        assertEquals(myArrayList.get(INDEX_TEST), normalList.get(INDEX_TEST));
        assertEquals(myArrayList.get(INDEX_TEST), value);
        assertNull(myArrayList.get(myArrayList.size()));
    }

    @Test
    public void add() {
        myArrayList.add(value);
        assertEquals(value, myArrayList.get(myArrayList.size() - 1));
        myArrayList.add(INDEX_TEST, value);
        assertEquals(value, myArrayList.get(INDEX_TEST));
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
