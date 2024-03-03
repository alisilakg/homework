public class Car implements Comparable<Car> {
    int id;
    String name;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Car o) {
        return this.id - o.id;
    }
}
