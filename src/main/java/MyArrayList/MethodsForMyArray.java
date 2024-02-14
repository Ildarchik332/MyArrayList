package MyArrayList;

/**
 * Методы для реализации своего ArrayList
 */
public interface MethodsForMyArray<E> extends Iterable<E> {
    /**
     * Метод добавления
     */
    boolean add(E e);

    /**
     * Метод добавления по индексу
     */
    boolean addByIndex(int index, E e);

    /**
     * Метод удаления по индексу
     */
    boolean deleteByIndex(int index);

    /**
     * Метод для получения
     */
    E get(int index);

    /**
     * Метод для получения размера листа
     */
    int size();

    /**
     * Метод для обновления значения по индексу
     */
    void update(int index, E e);

    /**
     * Метод для удаления всех элементов
     */
    void deleteAll();

}
