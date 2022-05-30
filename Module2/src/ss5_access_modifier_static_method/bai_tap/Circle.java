package ss5_access_modifier_static_method.bai_tap;

public class Circle {
    private  double radius = 1;
    public String color ="red";

    public Circle(){
    }

    public Circle(double radius,String color){
    this.radius=radius;
    this.color=color;
    }

    public double getRadius(){
        return  this.radius;

    }
    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI*Math.pow(this.radius,2);
    }

}
