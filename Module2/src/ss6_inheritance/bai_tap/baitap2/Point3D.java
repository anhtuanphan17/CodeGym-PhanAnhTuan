package ss6_inheritance.bai_tap.baitap2;

import ss6_inheritance.bai_tap.baitap2.Point2D;

public class Point3D extends Point2D {
    public float z = 0.0f;

    public Point3D(float x,float y,float z){
    super(x,y);
    this.z=z;
    }
    public Point3D(){

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x,float y,float z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public float[] getXYZ(){
       float[]XYZ = {x,y,z};
        return XYZ ;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
