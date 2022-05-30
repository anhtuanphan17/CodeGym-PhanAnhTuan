package ss7_abstract_and_interface.bai_tap.bai_tap1;



import ss6_inheritance.thuc_hanh.Circle;
import ss6_inheritance.thuc_hanh.Rectangle;
import ss6_inheritance.thuc_hanh.Square;

public class TestResizeable {
    public static void main(String[] args) {
        System.out.println("resize circle");
        Circle circle = new Circle(2);
        System.out.println(circle.getArea());
        circle.resize(20);
        System.out.println(circle.getArea());

        System.out.println("resize rectangle");
        Rectangle rectangle = new Rectangle(2,4);
        System.out.println(rectangle.getArea());
        rectangle.resize(30);
        System.out.println(rectangle.getArea());

        System.out.println("resize square");
        Square square = new Square(2);
        System.out.println(square.getArea());
        square.resize(40);
        System.out.println(square.getArea());
    }

}


