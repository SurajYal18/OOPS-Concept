//Open-closed Principle
//open for new features and closed for changes in existed one
//can be done using abstraction and polymorphism and encapsulation
// public class AreaCalculator {

//     public double calculateArea(Object shape) {
//         double area = 0;

//         if (shape instanceof Circle) {
//             Circle c = (Circle) shape;
//             area = Math.PI * c.radius * c.radius;
//         } else if (shape instanceof Rectangle) {
//             Rectangle r = (Rectangle) shape;
//             area = r.length * r.breadth;
//         }
//         return area;
//     }
// }

// class Circle {
//     public double radius;

//     public Circle(double radius) {
//         this.radius = radius;
//     }
// }

// class Rectangle {
//     public double length;
//     public double breadth;

//     public Rectangle(double length, double breadth) {
//         this.length = length;
//         this.breadth = breadth;
//     }
// }

interface Shape{
    double calculateArea();
}

class Rectangle implements Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }
}

class Circle implements Shape{
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}

class AreaCalculator{
    public double calculateArea(Shape shape){
        return shape.calculateArea();
    }
}

public class OCP {
    public static void main(String[] args) {
        Shape circle=new Circle(5);
        Shape rectangle=new Rectangle(4,6);
        AreaCalculator calculator=new AreaCalculator();
        double area1=calculator.calculateArea(circle);
        double area2=calculator.calculateArea(rectangle);
        System.out.println("Area of circle: "+area1);
        System.out.println("Area of rectangle: "+area2);
    }
}
