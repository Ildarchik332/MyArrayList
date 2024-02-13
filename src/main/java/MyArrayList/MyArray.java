package MyArrayList;

import java.util.*;

/**
 * Класс с реализацией функционала для собственного ArrayList
 */
public class MyArray<E> implements MethodsForMyArray<E> {
    public static void main(String[] args) {
        MyArray<String> array = new MyArray<>();
        array.add("dog");
        array.add("cat");
        array.add("frog");
        for (String x : array) {
            System.out.println(x);
        }
        System.out.println();
        array.addByIndex(0, "XXXX");
        array.addByIndex(4, "AAAA");
        for (String x : array) {
            System.out.println(x);
        }
        System.out.println();
        array.deleteAll();
        for (String x : array) {
            System.out.println(x);
        }


        MyArray<String> myArray = new MyArray<>();
        myArray.add("Pik");
        myArray.add("lik");
        myArray.add("avvv");
        myArray.add("deee");

        MyArray.quickSort(myArray.values, 0, myArray.values.length - 1);

        String[] array2 = {"Ильдар", "Андрей", "Иван", "Кристина", "Таня", "Бакс", "Рич"};
        quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));


    }

    private E[] values;

    public MyArray() {
        values = (E[]) new Object[0];
    }

    public static <E extends Comparable<E>> void quickSort(E[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private static <E extends Comparable<E>> int partition(E[] arr, int low, int high) {
        E pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                E temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        E temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Реализация метода добавления
     */
    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
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
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
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
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
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
        return values[index];
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
            values = (E[]) new Object[0];
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }


    // public static void quickSort(int[] arr, int low, int high) {
    //     if (arr.length == 0) {
    //         return;
    //     }
    //     if (low >= high) {
    //         return;
    //     }
    //     int middle = low + (high - low) / 2;
    //     int pivot = arr[middle];

    //     int i = low;
    //     int j = high;
    //     while (i <= j) {
    //         while (arr[i] < pivot) {
    //             i++;
    //         }
    //         while (arr[j] > pivot) {
    //             j--;
    //         }
    //         if (i <= j) {
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //             i++;
    //             j--;
    //         }
    //     }
    //     if (low < j) {
    //         quickSort(arr, low, j);
    //     }
    //     if (high > i) {
    //         quickSort(arr, i, high);
    //     }
    // }

    /**
     *
     */
    @Override
    public Iterator<E> iterator() {
        return new IteratorForMyArray<>(values);
    }

}
