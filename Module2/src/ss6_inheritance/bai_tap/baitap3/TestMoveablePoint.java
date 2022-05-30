package ss6_inheritance.bai_tap.baitap3;

import ss6_inheritance.bai_tap.baitap3.MovablePoint;
import ss6_inheritance.bai_tap.baitap3.Point;

public class TestMoveablePoint {
    public static void main(String[] args) {

        Point movablePoint = new MovablePoint();
        movablePoint.setX(2);
        movablePoint.setY(5);


        ((MovablePoint)movablePoint).setXSpeed(2);
        ((MovablePoint)movablePoint).setYSpeed(2);
        System.out.println(movablePoint);
        ((MovablePoint)movablePoint).move();
        System.out.println(movablePoint);



    }
}
