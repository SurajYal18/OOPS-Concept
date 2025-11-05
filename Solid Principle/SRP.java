
// public class Student {
//     private String name;
//     private int marks;

//     public Student(String name, int marks) {
//         this.name = name;
//         this.marks = marks;
//     }

//     public void printReport() {
//         System.out.println("Student: " + name + ", Marks: " + marks);
//     }

//     public void saveToDatabase() {
//         System.out.println("Saving student data to database...");
//     }
// }

//Above code violate srp due to all login in one class and doing more then one job

class student{
    private String name;
    private int marks;

    public student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

}

class studentRepostory{
    public void Save(student student){
        System.out.println("Saving student data to database...");
    }
}

public class SRP{
    public static void main(String[] args) {
        student student = new student("John", 85);
        studentRepostory repostory = new studentRepostory();
        repostory.Save(student);
        System.out.println("Student: " + student.getName() + ", Marks: " + student.getMarks());
    }

}
