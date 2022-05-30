package ss7_abstract_and_interface.thuc_hanh.thuc_hanh2;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {

        ComparableCircle[] comparableCircles = new ComparableCircle[3];

        comparableCircles[0]=new ComparableCircle(3.6);
        comparableCircles[1] =new ComparableCircle(2);
        comparableCircles[2] =new ComparableCircle(5.2, "blue",false);

        for (ComparableCircle circle:comparableCircles
             ) {
            System.out.println(circle);
        }

        System.out.println("after sort");
        Arrays.sort(comparableCircles);

        for (ComparableCircle circle:comparableCircles
             ) {
            System.out.println(circle);
        }


    }
}
