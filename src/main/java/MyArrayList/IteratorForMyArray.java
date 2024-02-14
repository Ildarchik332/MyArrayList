package MyArrayList;

import java.util.Iterator;

/**
 * Кастомный Iterator для собственного ArrayList
 */
public class IteratorForMyArray<E> implements Iterator<E> {
    private Integer index = 0;
    private Object[] values;

    public IteratorForMyArray(Object[] values) {
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
     * @return
     */
    @Override
    public E next() {
        return (E) values[index++];
    }

}
