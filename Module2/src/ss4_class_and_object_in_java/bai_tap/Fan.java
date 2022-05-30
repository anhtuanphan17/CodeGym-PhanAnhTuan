package ss4_class_and_object_in_java.bai_tap;

public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    private int speed;
    private boolean status = false;
    private double radius = 5;
    private String color = " blue ";

    public Fan(int speed, boolean status, double radius, String color) {
        this.speed = speed;
        this.status = status;
        this.radius = radius;
        this.color = color;
    }


    public int getSpeed() {

        return speed;
    }

    public void setSpeed(int speed) {
        if (speed == this.SLOW) {
            this.speed = this.SLOW;
        } else if (speed == this.MEDIUM) {
            this.speed = this.MEDIUM;
        } else if (speed == this.FAST) {
            this.speed = this.FAST;
        } else {
            System.out.println("not valid speed");
        }
    }

    public String getStatus() {
        if (this.status) {
            return " is turning on";
        } else {
            return " is turning off";
        }
    }

    public void setStatus(String status) {
        this.status = status.equals("on");
    }

    public double getRadius() {

        return radius;
    }

    public void setRadius(double radius) {

        this.radius = radius;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public String toString() {
        return "Fan {speed= " + this.getSpeed() + ", radius= " + this.getRadius() +
                ", color= " + this.getColor() + ", fan is " + this.getStatus() + "}";

    }

    public static void main(String[] args) {
        Fan fan1 = new Fan(3, true, 5, "blue");
        System.out.println(fan1);


    }
}







