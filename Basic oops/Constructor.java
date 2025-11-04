class Student{
    String name;
    int age;

    Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    Student(){
        System.out.println("Default constructor called");
    }

}

public class Constructor {
    public static void main(String[] args) {
        Student s1=new Student("John",20);
        Student s2=new Student();
        System.out.println("Name: "+s1.name);
        System.out.println("Age: "+s1.age);
        System.out.println(s2);
    }
}
