class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("Car is driving at " + speed + " km/h");
    }
}

public class Simple{
    public static void main(String[] args) {
        Car c1 = new Car(); // Object creation
        c1.color = "Red";
        c1.speed = 120;
        c1.drive();
    }
}
