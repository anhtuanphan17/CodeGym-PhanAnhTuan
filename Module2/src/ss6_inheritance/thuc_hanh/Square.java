package ss6_inheritance.thuc_hanh;

import ss7_abstract_and_interface.bai_tap.bai_tap1.Resizeable;
import ss7_abstract_and_interface.bai_tap.bai_tap2.Colorable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getArea()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        super.resize(percent);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
