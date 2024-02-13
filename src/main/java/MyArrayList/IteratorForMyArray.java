package MyArrayList;

import java.util.Iterator;

/**
 * Кастомный Iterator для собственного ArrayList
 */
public class IteratorForMyArray<E> implements Iterator<E> {
    private int index = 0;
    private E[] values;

    public IteratorForMyArray(E[] values) {
        this.values = values;
    }

    /**
     * Метод для проверки существования элемента
     */
    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    /**
     * Метод возвращает элемент
     */
    @Override
    public E next() {
        return values[index++];
    }

}
