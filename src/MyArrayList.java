/**
 * Моя реализация динамического массива ArrayList.
 *
 * @param <T> тип элементов в списке.
 *
 * Так как список можно будет сортировать, элемент должен имплементировать интерфейс Comparable.
 */
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    /**
     * Внутренний массив типа Т.
     */
    private T[] array;

    /**
     * Количество элементов в списке.
     */
    private int size;

    /**
     * Конструктор для создания пустого списка с емкостью по умолчанию (10).
     */
    public MyArrayList() {
        array = (T[]) new Comparable[10];
    }

    /**
     * Добавляет указанный элемент в конец списка.
     *
     * @param data элемент, который будет добавлен в список.
     */
    @Override
    public void add(T data) {
        if (size == 0 || size < array.length) {
            array[size] = data;
            size++;
        } else if (array.length == size) {
            T[] newArray = (T[]) new Comparable[array.length * 3 / 2 + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[size] = data;
            size++;
        }
    }

    /**
     * Добавляет указанный элемент в указанную позицию в списке.
     * Смещает элементы, находящийся правее этой позиции, на одну позицию вправо.
     *
     * @param index   индекс, по которому должен быть вставлен указанный элемент.
     * @param data элемент, который должен быть вставлен.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index > size()).
     */
    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            T[] newArray = (T[]) new Comparable[array.length * 3 / 2 + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = data;
            size++;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = data;
            size++;
        }
    }

    /**
     * Возвращает элемент находящийся в указанной позиции в списке.
     *
     * @param index индекс возвращаемого элемента.
     * @return элемент в указанной позиции в списке.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * Удаляет элемент находящийся в указанной позиции в списке.
     * Смещает элементы, находящийся правее этой позиции, на одну позицию влево.
     *
     * @param index индекс элемента, который нужно удалить.
     * @return элемент, который был удален из списка.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
     */
    @Override
    public T delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        T current = array[index];
        System.arraycopy(array, index + 1, array, index, size - index);
        size--;
        return current;
    }

    /**
     * Удаляет все элементы из списка.
     *
     * @return true, когда все элементы удалены.
     */
    @Override
    public boolean clear() {
        T[] newArray = (T[]) new Comparable[array.length];
        array = newArray;
        size = 0;
        return true;
    }

    /**
     * Сортировка списка в естественном порядке(возрастание), реализовано через быструю сортировку.
     */
    public void sort() {
        quickSort(array, 0, size - 1);
    }

    /**
     * Метод получения количества элемента в списке.
     *
     * @return значение типа int.
     */
    public int size() {
        return size;
    }

    /**
     * Печать списка в консоль.
     * Если список пустой выводится "[]".
     */
    @Override
    public void printList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String separator = "";
        for (int i = 0; i < size; i++) {
            stringBuilder.append(separator).append(array[i]);
            separator = ", ";
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    /**
     * Реализация быстрой сортировки.
     */
    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Реализация быстрой сортировки.
     * В качестве опорного элемента выбран элемент из середины списка.
     */
    private int partition(T[] arr, int low, int high) {
        int middle = low + (high - low) / 2;
        T pivot = arr[middle];

        T temp = arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
