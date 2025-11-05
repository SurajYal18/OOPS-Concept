// The Interface Segregation Principle says:

// No client should be forced to depend on methods it does not use.
// interface Worker {
//     void work();

//     void eat();
// }

// class HumanWorker implements Worker {
//     @Override
//     public void work() {
//         System.out.println("Human is working...");
//     }

//     @Override
//     public void eat() {
//         System.out.println("Human is eating lunch...");
//     }
// }

// class RobotWorker implements Worker {
//     @Override
//     public void work() {
//         System.out.println("Robot is working...");
//     }

//     @Override
//     public void eat() {
//         // Robots don't eat, but forced to implement this method!
//         System.out.println("Robot cannot eat!");
//     }
// }
interface Workable{
    void work();
}
interface Eatable{
    void eat();
}

class HumanWorker implements Workable,Eatable{
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating lunch...");
    }
}

class RobotWorker implements Workable{
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}


public class ISP {
    public static void main(String[] args) {
        HumanWorker humanWorker=new HumanWorker();
        Workable robotWorker=new RobotWorker();
        humanWorker.work();
        humanWorker.eat();
        robotWorker.work();
    }
}
