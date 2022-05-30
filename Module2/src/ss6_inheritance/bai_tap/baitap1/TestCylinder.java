package ss6_inheritance.bai_tap.baitap1;

import ss6_inheritance.bai_tap.baitap1.Circle1;
import ss6_inheritance.bai_tap.baitap1.Cylinder;

public class TestCylinder {
    public static void main(String[] args) {

        Circle1 circle1 = new Circle1();
        System.out.println(circle1);
        Circle1 circle2 = new Circle1(2);
        System.out.println(circle2);

        Cylinder cylinder1= new Cylinder(2,3);
        System.out.println(cylinder1);




    }
}
