package MyArrayList;

import org.junit.Assert;
import org.junit.Test;

public class MyArrayTest {
    MyArray<String> myArray = new MyArray<>();
    MyArray<String> actual = new MyArray<>();

    @Test
    public void add() {
        Assert.assertTrue(myArray.add("Hello"));
    }

    @Test
    public void addIndex() {
        Assert.assertTrue(myArray.addByIndex(0, "Ter"));
    }

    @Test
    public void deleteByIndex() {
        myArray.add("aaa");
        myArray.add("bbb");
        myArray.add("ccc");
        myArray.add("ddd");

        Assert.assertTrue(myArray.deleteByIndex(3));
        Assert.assertTrue(myArray.deleteByIndex(1));
    }

    @Test
    public void get() {
        myArray.add("aaa");
        myArray.add("bbb");
        myArray.add("ccc");
        myArray.add("ddd");
        String expected = "bbb";
        Assert.assertEquals(expected, myArray.get(1));
    }

    @Test
    public void size() {
        myArray.add("aaa");
        myArray.add("bbb");
        myArray.add("ccc");
        myArray.add("ddd");
        int expected = 4;
        Assert.assertEquals(expected, myArray.size());
    }

    @Test
    public void update() {
        myArray.add("aaa");
        myArray.add("bbb");
        myArray.add("ccc");
        myArray.add("ddd");
        myArray.update(1, "eeee");
        String expected = "eeee";
        Assert.assertEquals(expected, myArray.get(1));
    }

    @Test
    public void deleteAll() {
        myArray.add("aaa");
        myArray.add("bbb");
        myArray.add("ccc");
        myArray.add("ddd");
        myArray.deleteAll();
        int expected = 0;
        Assert.assertEquals(expected, myArray.size());
    }

    @Test
    public void quickSort() {
        myArray.add("ccc");
        myArray.add("ddd");
        myArray.add("bbb");
        myArray.add("aaa");
        MyArray.quickSort(myArray, 0, myArray.size() -1 );

        actual.add("aaa");
        actual.add("bbb");
        actual.add("ccc");
        actual.add("ddd");
        Assert.assertEquals(myArray, actual);
    }
}
