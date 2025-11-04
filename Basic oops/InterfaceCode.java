interface Drawable{
    void draw();

}

interface Colorable{
    void fillColor();
}

class Rectangle implements Drawable,Colorable{
     public void draw(){
        System.out.println("Drawing Rectangle");
     }

     public void fillColor(){
        System.out.println("Filling Rectangle with color");
     }
}

public class InterfaceCode {
    
   public static void main(String[] args) {
        Rectangle rect=new Rectangle();
        rect.draw();
        rect.fillColor();
    }

    
}
