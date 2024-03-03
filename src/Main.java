public class Main {
    public static void main(String[] args) {
        System.out.println("Связный список int: ");
        MyLinkedList<Integer> linkedList1 = new MyLinkedList<>();
        linkedList1.addToHead(1);
        linkedList1.addToHead(8);
        linkedList1.addToHead(5);
        linkedList1.printList();
        // 5 <=> 8 <=> 1
        linkedList1.add(3);
        linkedList1.printList();
        // 5 <=> 8 <=> 1 <=> 3
        linkedList1.add(3, 10);
        linkedList1.printList();
        // 5 <=> 8 <=> 1 <=> 10 <=> 3
        linkedList1.delete(2);
        linkedList1.printList();
        // 5 <=> 8 <=> 10 <=> 3
        linkedList1.deleteHead();
        linkedList1.printList();
        // 8 <=> 10 <=> 3
        linkedList1.addToHead(14);
        linkedList1.printList();
        // 14 <=> 8 <=> 10 <=> 3
        linkedList1.add(40);
        linkedList1.printList();
        // 14 <=> 8 <=> 10 <=> 3 <=> 40
        linkedList1.deleteHead();
        linkedList1.printList();
        // 8 <=> 10 <=> 3 <=> 40
        linkedList1.add(56);
        linkedList1.printList();
        // 8 <=> 10 <=> 3 <=> 40 <=> 56
        linkedList1.deleteTail();
        linkedList1.printList();
        // 8 <=> 10 <=> 3 <=> 40

        System.out.println("Первый элемент связного списка: " + linkedList1.getHead());
        System.out.println("Последний элемент связного списка: " + linkedList1.getTail());
        int index = 2;
        System.out.println("Элемент связного списка с индексом " + index + " : " + linkedList1.get(index));

        linkedList1.sort();
        System.out.print("Отсортированный список: ");
        linkedList1.printList();

        System.out.println("Связный список очищен: " + linkedList1.clear());
        linkedList1.printList();



        System.out.println("Связный список String: ");
        MyLinkedList<String> linkedList2 = new MyLinkedList<>();
        linkedList2.addToHead("a");
        linkedList2.addToHead("e");
        linkedList2.addToHead("c");
        linkedList2.printList();
        // c <=> e <=> a
        linkedList2.add("b");
        linkedList2.printList();
        // c <=> e <=> a <=> b
        linkedList2.add(3, "d");
        linkedList2.printList();
        // c <=> e <=> a <=> d <=> b
        linkedList2.delete(2);
        linkedList2.printList();
        // c <=> e <=> d <=> b
        linkedList2.deleteHead();
        linkedList2.printList();
        // e <=> d <=> b
        linkedList2.addToHead("f");
        linkedList2.printList();
        // f <=> e <=> d <=> b
        linkedList2.add("a");
        linkedList2.printList();
        // f <=> e <=> d <=> b <=> a
        linkedList2.deleteHead();
        linkedList2.printList();
        // e <=> d <=> b <=> a
        linkedList2.add("g");
        linkedList2.printList();
        // e <=> d <=> b <=> a <=> g
        linkedList2.deleteTail();
        linkedList2.printList();
        // e <=> d <=> b <=> a

        System.out.println("Первый элемент связного списка: " + linkedList2.getHead());
        System.out.println("Последний элемент связного списка: " + linkedList2.getTail());
        System.out.println("Элемент связного списка с индексом " + index + " : " + linkedList2.get(index));

        linkedList2.sort();
        System.out.print("Отсортированный список: ");
        linkedList2.printList();

        System.out.println("Связный список очищен: " + linkedList2.clear());
        linkedList2.printList();


        System.out.println("Связный список объектов типа Car: ");
        MyLinkedList<Car> linkedList3 = new MyLinkedList<>();
        Car car = new Car(1, "Super");
        Car car2 = new Car(2, "Puper");
        Car car3 = new Car(3, "Duper");
        linkedList3.addToHead(car2);
        linkedList3.addToHead(car);
        linkedList3.addToHead(car3);
        linkedList3.printList();
        // 3 <=> 1 <=> 2
        Car car5 = new Car(5, "Nuper");
        linkedList3.add(car5);
        linkedList3.printList();
        // 3 <=> 1 <=> 2 <=> 5
        Car car4 = new Car(4, "Juper");
        linkedList3.add(1, car4);
        linkedList3.printList();
        // 3 <=> 4 <=> 1 <=> 2 <=> 5
        linkedList3.delete(2);
        linkedList3.printList();
        // 3 <=> 4 <=> 2 <=> 5
        linkedList3.deleteHead();
        linkedList3.printList();
        // 4 <=> 2 <=> 5
        Car car6 = new Car(6, "Wuper");
        linkedList3.addToHead(car6);
        linkedList3.printList();
        // 6 <=> 4 <=> 2 <=> 5

        System.out.println("Первый элемент связного списка: " + linkedList3.getHead());
        System.out.println("Последний элемент связного списка: " + linkedList3.getTail());
        index = 1;
        System.out.println("Элемент связного списка с индексом " + index + " : " + linkedList3.get(index));

        linkedList3.sort();
        System.out.print("Отсортированный список машин. Сортировка по возрастанию id: ");
        linkedList3.printList();

        System.out.println("Связный список очищен: " + linkedList3.clear());
        linkedList3.printList();
    }

}