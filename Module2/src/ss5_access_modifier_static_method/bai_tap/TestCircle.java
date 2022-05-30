package ss5_access_modifier_static_method.bai_tap;

import ss5_access_modifier_static_method.bai_tap.Circle;

public class TestCircle {
    public static void main(String[] args) {


        Circle circle1 = new Circle();
        System.out.println(circle1.color);

        circle1.setRadius(2);

        System.out.println("Radius is: "+ circle1.getRadius());
        System.out.println("Area is: " + circle1.getArea());




    }
}
