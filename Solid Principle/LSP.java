//Objects of a superclass should be replaceable with objects of its
// subclasses without breaking the application.
// class Bird {
//     public void fly() {
//         System.out.println("This bird can fly");
//     }
// }

// class Sparrow extends Bird {
//     // Sparrow can fly, so no issue here
// }

// class Ostrich extends Bird {
//     // Ostrich cannot fly, but still inherits fly() method
// }

interface Bird{
    void eat();
}

interface flyingBird extends Bird{
    void fly();
}

class Sparrow implements flyingBird{
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow is eating");
    }
}

class Ostrich implements Bird{

    @Override
    public void eat() {
        System.out.println("Ostrich is eating");
    }
    

}

public class LSP {
    public static void main(String[] args) {
        flyingBird sparrow=new Sparrow();
        Bird ostrich=new Ostrich();
        sparrow.fly();
        sparrow.eat();
        ostrich.eat();

    }
}
