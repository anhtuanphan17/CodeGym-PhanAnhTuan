package ss6_inheritance.bai_tap.baitap2;

import ss6_inheritance.bai_tap.baitap2.Point2D;
import ss6_inheritance.bai_tap.baitap2.Point3D;

public class TestPoin2D {
    public static void main(String[] args) {
        Point2D point2d =new Point2D(1,3);
        System.out.println(point2d);


        Point3D point3D= new Point3D(2,3,5);
        System.out.println(point3D);

        point3D.setXYZ(1,2,3);
        System.out.println(point3D);




    }
}
