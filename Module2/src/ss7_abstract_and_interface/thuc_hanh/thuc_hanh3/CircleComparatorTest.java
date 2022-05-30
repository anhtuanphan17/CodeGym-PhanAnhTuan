package ss7_abstract_and_interface.thuc_hanh.thuc_hanh3;


import ss7_abstract_and_interface.thuc_hanh.thuc_hanh3.Circle;
import ss7_abstract_and_interface.thuc_hanh.thuc_hanh3.CircleComparator;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {


        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);

        System.out.println("before sorting");

        for (Circle circle : circles
        ) {
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles,circleComparator);

        for (Circle circle : circles
        ) {
            System.out.println(circle);

        }

    }
}
