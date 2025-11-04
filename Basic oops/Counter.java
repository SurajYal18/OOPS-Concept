class Counters {
    static int count = 0; // static variable shared by all objects

    Counters() {
        count++; // increments every time a new object is created
    }

    static void showCount() {
        System.out.println(count); // displays the total count
    }
}

public class Counter {
    public static void main(String[] args) {
        new Counters();
        new Counters();
        Counters.showCount(); // Output: 2
    }
}
