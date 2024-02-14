package MyArrayList;

import java.util.*;

/**
 * Класс с реализацией функционала для собственного ArrayList
 */
public class MyArray<E extends Comparable<E>> implements MethodsForMyArray<E> {

    private Object[] values;
    private static final Object[] DEFAULT_DATA = {};

    public MyArray() {
        values = DEFAULT_DATA;
    }

    /**
     * Реализация метода добавления
     */
    @Override
    public boolean add(E e) {
        try {
            Object[] temp = values;
            values = new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Реализация метода для добавления по индексу
     */
    @Override
    public boolean addByIndex(int index, E e) {
        try {
            Object[] temp = values;
            values = new Object[temp.length + 1];
            if (index != values.length - 1) {
                System.arraycopy(temp, 0, values, 0, index);
                int ElementsAfterIndex = temp.length - index;
                System.arraycopy(temp, index, values, index + 1, ElementsAfterIndex);
                values[index] = e;
            } else {
                System.arraycopy(temp, 0, values, 0, temp.length);
                values[values.length - 1] = e;
            }
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Реализация удаления из списка по индексу
     */
    @Override
    public boolean deleteByIndex(int index) {
        try {
            Object[] temp = values;
            values = new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int ElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, ElementsAfterIndex);
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            return false;

        }

    }

    /**
     * Реализация метода получения элемента
     */
    @Override
    public E get(int index) {
        return (E) values[index];
    }

    /**
     * Реализация метода для получения размера листа
     */
    @Override
    public int size() {
        return values.length;
    }

    /**
     * Реализация метода для обновления значения по индексу
     */
    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    /**
     * Реализация метода для удаления всех элементов
     */
    @Override
    public void deleteAll() {
        try {
            values = new Object[0];
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Метод быстрой сортировки
     */
    public static <E extends Comparable<E>> void quickSort(MyArray<E> myArray, int low, int high) {
        if (low < high) {
            int pi = partition(myArray, low, high);

            quickSort(myArray, low, pi - 1);
            quickSort(myArray, pi + 1, high);
        }
    }

    /**
     * Основная логика быстрой сортировки вынесена в отдельный метод
     */
    private static <E extends Comparable<E>> int partition(MyArray<E> arr, int low, int high) {
        E pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j).compareTo(pivot) <= 0) {
                i++;
                E temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        E temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

    E values(int index) {
        return (E) values[index];
    }

    /**
     * Метод для замены элемента в списке(реализован только для сортировки)
     */
    public E set(int index, E element) {
        Objects.checkIndex(index, values.length);
        E oldValue = values(index);
        values[index] = element;
        return oldValue;
    }

    /**
     * Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new IteratorForMyArray<>(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArray<?> myArray = (MyArray<?>) o;
        return Arrays.equals(values, myArray.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
