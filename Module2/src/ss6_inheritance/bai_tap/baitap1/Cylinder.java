package ss6_inheritance.bai_tap.baitap1;

import ss6_inheritance.bai_tap.baitap1.Circle1;

public class Cylinder extends Circle1 {
    public double height=5;

    public Cylinder(double height,double radius){
    super(radius);
    this.height=height;
    }

    public double getCylinderVolume(){
        return Math.PI*Math.pow(radius,2)*this.height;
    }

    public void setHeight(double height){
        this.height=height;
    }
    public double getHeight(){
        return this.height;
    }

    @Override
    public String toString() {
         return  "Cylinder with radius is "+ getRadius()
                +"Height is " + getHeight()
                +"volume is: "+ getCylinderVolume();
    }
}
