package ss7_abstract_and_interface.thuc_hanh.thuc_hanh2;


import ss7_abstract_and_interface.thuc_hanh.thuc_hanh3.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }
    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }


    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius()>o.getRadius()) {
            return 1;
        }else if(getRadius()<o.getRadius()){
            return -1;
        }else{
            return 1;
        }

    }
}
