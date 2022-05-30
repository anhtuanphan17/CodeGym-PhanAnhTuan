package ss6_inheritance.bai_tap.baitap1;

public class Circle1 {
    public double radius =1;
    public String color;

    public Circle1(){

    }
    public Circle1(double radius){
    this.radius=radius;
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

    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }


    public String toString(){
        return "A Circle with radius is:"+ getRadius()+
                " And area is: " + getArea();
    }

}

