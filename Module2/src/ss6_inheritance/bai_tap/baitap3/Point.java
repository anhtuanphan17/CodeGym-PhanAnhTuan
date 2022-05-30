package ss6_inheritance.bai_tap.baitap3;

public class Point {
    public float x = 0.0f;
    public float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] XY = {x, y};
        return XY;
    }

    public String toString() {
        return "Point{x= "+getX()+
                "y= "+ getY()+
                "}";
    }

}
