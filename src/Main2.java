public class Main2 {
    public static void main(String[] args) {
        System.out.println("Список int: ");
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("Размер списка до добавления элементов: " + list.size());
        list.add(1);
        System.out.println("Размер списка после добавления элемента 1 в позицию 0: " + list.size());
        list.printList();

        for (int i = 2; i <= 15; i++) {
            list.add(i);
        }
        System.out.println("Размер списка после добавления 14 элементов: " + list.size());
        list.printList();

        list.add(1, 0);
        System.out.println("Размер списка после добавления элемента 0 в позицию 1: " + list.size());
        list.printList();

        list.add(0, 0);
        System.out.println("Размер списка после добавления элемента 0 в позицию 0: " + list.size());
        list.printList();

        list.add(list.size(), 0);
        System.out.println("Размер списка после добавления элемента 0 в конец списка: " + list.size());
        list.printList();

        System.out.println("Элемент в позицию 2: " + list.get(2));

        int index = 5;
        System.out.println("Элемент " + list.delete(index) + " с индексом " + index + " удалён");
        System.out.println("Размер списка после удаления элемента: " + list.size());
        list.printList();

        list.sort();
        System.out.print("Отсортированный список: ");
        list.printList();

        System.out.println("Список удалён: " + list.clear());
        System.out.println("Размер списка после удаления всех элементов: " + list.size());
        list.printList();



        System.out.println("Список String: ");
        MyArrayList<String> list2 = new MyArrayList<>();
        System.out.println("Размер списка до добавления элементов: " + list2.size());
        list2.add("a");
        System.out.println("Размер списка после добавления элемента 1 в позицию 0: " + list2.size());
        list2.printList();

        char[] arrayChars = "bcdzefjghmonsldf".toCharArray();
        for (int i = 2; i <= 15; i++) {
            list2.add(String.valueOf(arrayChars[i]));
        }
        System.out.println("Размер списка после добавления 14 элементов: " + list2.size());
        list2.printList();

        list2.add(1, "A");
        System.out.println("Размер списка после добавления элемента A в позицию 1: " + list2.size());
        list2.printList();

        list2.add(0, "A");
        System.out.println("Размер списка после добавления элемента A в позицию 0: " + list2.size());
        list2.printList();

        list2.add(list2.size(), "A");
        System.out.println("Размер списка после добавления элемента A в конец списка: " + list2.size());
        list2.printList();

        System.out.println("Элемент в позицию 2: " + list2.get(2));

        System.out.println("Элемент " + list2.delete(index) + " с индексом " + index + " удалён");
        System.out.println("Размер списка после удаления элемента: " + list2.size());
        list2.printList();

        list2.sort();
        System.out.print("Отсортированный список: ");
        list2.printList();

        System.out.println("Список удалён: " + list2.clear());
        System.out.println("Размер списка после удаления всех элементов: " + list2.size());
        list2.printList();



        System.out.println("Список объектов типа Car: ");
        MyArrayList<Car> list3 = new MyArrayList<>();
        Car car = new Car(1, "Super");
        Car car2 = new Car(2, "Puper");
        Car car3 = new Car(3, "Duper");
        Car car5 = new Car(5, "Nuper");
        Car car4 = new Car(4, "Juper");
        Car car6 = new Car(6, "Wuper");
        System.out.println("Размер списка до добавления элементов: " + list3.size());
        list3.add(car);
        System.out.println("Размер списка после добавления элемента 1 в позицию 0: " + list3.size());
        list3.printList();

        list3.add(car2);
        list3.add(car6);
        list3.add(car4);
        list3.add(car5);
        System.out.println("Размер списка после добавления ещё 4х элементов: " + list3.size());
        list3.printList();

        list3.add(1, car3);
        System.out.println("Размер списка после добавления " + car3 + " в позицию 1: " + list3.size());
        list3.printList();

        list3.add(0, car3);
        System.out.println("Размер списка после добавления " + car3 + " в позицию 0: " + list3.size());
        list3.printList();

        list3.add(list3.size(), car3);
        System.out.println("Размер списка после добавления " + car3 + " в конец списка: " + list3.size());
        list3.printList();

        System.out.println("Элемент в позицию 2: " + list3.get(2));

        System.out.println("Элемент " + list3.delete(index) + " с индексом " + index + " удалён");
        System.out.println("Размер списка после удаления элемента: " + list3.size());
        list3.printList();

        list3.sort();
        System.out.print("Отсортированный список машин. Сортировка по возрастанию id:");
        list3.printList();

        System.out.println("Список удалён: " + list3.clear());
        System.out.println("Размер списка после удаления всех элементов: " + list3.size());
        list3.printList();
    }
}
