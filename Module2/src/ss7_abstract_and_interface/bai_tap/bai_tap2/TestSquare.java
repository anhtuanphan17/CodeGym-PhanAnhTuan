package ss7_abstract_and_interface.bai_tap.bai_tap2;

import ss6_inheritance.thuc_hanh.Circle;
import ss6_inheritance.thuc_hanh.Rectangle;
import ss6_inheritance.thuc_hanh.Shape;
import ss6_inheritance.thuc_hanh.Square;

public class TestSquare {
    public static void main(String[] args) {

        Square square = new Square(2);
        square.howToColor();

        Shape [] shapes = new Shape[5];
        shapes[0]  = new Square(3);
        shapes[1]= new Rectangle(2,3);
        shapes[2] =new Circle(2);
        shapes[3]= new Circle(5);
        shapes[4]=new Rectangle(2,8);

        for (int i=0;i<shapes.length;i++){
            if(shapes[i] instanceof Square){
                square.howToColor();
                System.out.println("Area of this square is: "+((Square)shapes[i]).getArea());;
            }else if(shapes[i] instanceof Circle){
                System.out.println("Area of circle at positon "+ i+ " is " +((Circle)shapes[i]).getArea());;
            }else if(shapes[i] instanceof Rectangle){
                System.out.println("Area of rectangle at positon "+ i+ " is " +((Rectangle)shapes[i]).getArea());
            }
        }




    }
}
