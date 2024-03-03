/**
 * Моя реализация двусвязного списка LinkedList.
 *
 * @param <T> тип элементов в списке.
 *
 * Так как список можно будет сортировать, элемент должен имплементировать интерфейс Comparable.
 */
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
     /**
      * Первый узел = голова списка.
      */
     private Node<T> head;
     /**
      * Последний узел = хвост списка.
      */
     private Node<T> tail;

     /**
      * Вложенный класс "Узел".
      * Содержит указатели на следующий и предыдущий узлы.
      */
     private static class Node<T> {
          public T data;
          public Node<T> next;
          public Node<T> prev;

          /**
           * Конструктор, который создает новый узел.
           *
           * @param data значение, которое будет добавлено в узел.
           */
          public Node(T data) {
               this.data = data;
          }

          @Override
          public String toString() {
               return  data.toString();
          }
     }

     /**
      * Добавляет указанный элемент в конец списка.
      * Вызывает приватный метод добавление элемента в хвост списка.
      *
      * @param data значение, которое будет добавлено в список.
      */
     @Override
     public void add(T data) {
          addToTail(data);
     }

     /**
      * Добавляет указанный элемент в указанную позицию в списке.
      * Вызывает приватный метод добавление элемента по индексу.
      *
      * @param index индекс, по которому должен быть вставлен указанный элемент.
      * @param data значение, которое будет добавлено в список.
      * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index > size()).
      */
     @Override
     public void add(int index, T data) {
          addByIndex(index, data);
     }

     /**
      * Возвращает элемент находящийся в указанной позиции в списке.
      * Вызывает приватный метод получения элемента по индексу.
      *
      * @param index индекс возвращаемого элемента.
      * @return элемент в указанной позиции в списке.
      * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
      */
     @Override
     public T get(int index) {
          if (index < 0) {
               throw new IndexOutOfBoundsException();
          }
          return getByIndex(index);
     }

     /**
      * Удаляет элемент находящийся в указанной позиции в списке.
      * Вызывает приватный метод удаления элемента по индексу.
      *
      * @param index индекс элемента, который нужно удалить.
      * @return элемент, который был удален из списка.
      * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
      */
     @Override
     public T delete(int index) {
          if (index < 0) {
               throw new IndexOutOfBoundsException();
          }
          return deleteByIndex(index);
     }

     /**
      * Удаляет все элементы из списка.
      * Присваивает указателю на голову списка значение null.
      *
      * @return true, когда все элементы удалены.
      */
     @Override
     public boolean clear() {
          head = null;
          return true;
     }

     /**
      * Сортировка списка в естественном порядке(возрастание), реализовано через быструю сортировку.
      * Сначала происходит подсчёт узлов в списке, т.к. это значение заранее не известно.
      * Результат сохраняется в локальную переменную size.
      * Затем элементы из списка сохраняются в массив.
      * Происходит сортировка.
      * После список собирается заново, но уже в отсортированном виде.
      */
     @Override
     public void sort() {
          Node<T> current = head;
          int size = 0;
          while (current.next != null) {
               current = current.next;
               size++;
          }
          size++;
          T[] nodes = (T[]) new Comparable[size];
          current = head;
          for (int i = 0; i < size; i++) {
               nodes[i] = current.data;
               current = current.next;
          }
          quickSort(nodes, 0, size - 1);
          head = new Node<>(nodes[0]);
          tail = head;
          for (int i = 1; i < size; i++) {
               current = tail;
               Node<T> newNode = new Node<>(nodes[i]);
               newNode.prev = current;
               current.next = newNode;
               tail = newNode;
          }
     }

     /**
      * Печать списка в консоль.
      * Если список пустой выводится "Null".
      */
     @Override
     public void printList() {
          try {
               Node<T> current = head.next;
               StringBuilder stringBuilder = new StringBuilder();
               String separator = " <=> ";
               stringBuilder.append(head);
               while (current != null) {
                    stringBuilder.append(separator).append(current);
                    current = current.next;
               }
               System.out.println(stringBuilder);
          } catch (NullPointerException e) {
               System.out.println("Null");
          }

     }

     /**
      * Вставляет указанный элемент в начало списка.
      * Заменяет указатель на голову списка и ссылку на предыдущий узел в прошлом узле-голове.
      *
      * @param data значение, которое должно быть вставлно.
      */
     public void addToHead(T data) {
          Node<T> temp = head;
          Node<T> newNode = new Node<>(data);
          newNode.next = head;
          head = newNode;
          if (temp != null) {
               temp.prev = newNode;
          }
          if (tail == null) {
               tail = head;
          }
     }

     /**
      * Метод получения значения головы списка.
      *
      * @return значение элемента-головы.
      */
     public T getHead() {
          return head.data;
     }

     /**
      * Метод получения значения хвоста списка.
      *
      * @return значение элемента-хвоста.
      */
     public T getTail() {
          return tail.data;
     }

     /**
      * Метод удаления головы списка.
      * Заменяет ссылку на предыдущий узел в следующем за головой элементе на null.
      * Заменяет ссылку на голову списка.
      */
     public void deleteHead() {
          Node<T> newHead = head.next;
          newHead.prev = null;
          head = newHead;
     }

     /**
      * Метод удаления хвоста списка.
      * Заменяет ссылку на следующий узел в предыдущем за хвостом элементе на null.
      * Заменяет ссылку на хвост списка.
      */
     public void deleteTail() {
          Node<T> current = head;
          while(current.next != null) {
               current = current.next;
          }
          current.prev.next = null;
          tail = current.prev;
     }

     /**
      * Вставляет указанный элемент в конец списка.
      * Заменяет указатель на хвост списка и ссылку на следующий узел в прошлом узле-хвосте.
      *
      * @param data значение, которое должно быть вставлно.
      */
     private void addToTail(T data) {
          Node<T> current = tail;
          Node<T> newNode = new Node<>(data);
          newNode.prev = current;
          current.next = newNode;
          tail = newNode;
     }

     /**
      * Вставляет указанный элемент в список по индексу.
      * Перезаписывает у предыдущего и последующего узлов укузатели.
      * Новому узлу присваивает ссылки на предыдущий и последующие узлы.
      */
     private void addByIndex(int index, T data) {
          try {
               Node<T> current = head;
               for (int i = 0; i < index - 1; i++) {
                    current = current.next;
               }
               Node<T> newNode = new Node<>(data);
               newNode.prev = current;
               newNode.next = current.next;
               current.next = newNode;
          } catch (NullPointerException e) {
               throw new IndexOutOfBoundsException();
          }

     }

     /**
      * Возвращает элемент находящийся в указанной позиции в списке.
      *
      * @param index индекс возвращаемого элемента.
      * @return значение узла в указанной позиции в списке.
      * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
      */
     private T getByIndex(int index) {
          Node<T> current = head;
          for (int i = 0; i <= index - 1; i++) {
               current = current.next;
               if (current == null) {
                    throw new IndexOutOfBoundsException();
               }
          }
          return current.data;
     }

     /**
      * Удаляет элемент находящийся в указанной позиции в списке.
      * Перезаписывает у предыдущего и последующего узлов укузатели друг на друга.
      *
      * @param index индекс элемента, который нужно удалить.
      * @return элемент, который был удален из списка.
      * @throws IndexOutOfBoundsException если индекс выходит за пределы диапазона (index < 0 || index >= size()).
      */
     private T deleteByIndex(int index) {
          Node<T> current = head;
          T elementDelete = null;
          for (int i = 0; i < index - 1; i++) {
               current = current.next;
               if (current == null) {
                    throw new IndexOutOfBoundsException();
               }
               elementDelete = current.data;
          }
          current.next.prev = current;
          current.next = current.next.next;
          return elementDelete;
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
          T pivot = arr[high];
          int i = (low - 1);
          for (int j = low; j < high; j++) {
               if (arr[j].compareTo(pivot) < 0) {
                    i++;

                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
               }
          }

          T temp = arr[i + 1];
          arr[i + 1] = arr[high];
          arr[high] = temp;

          return i + 1;
     }

}
