class MathUtils{
    int add(int a,int b){
        return a+b;
    }

    double add(double a,double b){
        return a+b;
    }
}


public class MethodOverloading {
   public static void main(String[] args) {
    MathUtils math=new MathUtils();
    int result1=math.add(10,20);
    double result2=math.add(10.5,20.5);
    System.out.println("Result 1: "+result1);
    System.out.println("Result 2: "+result2);
   }
}
