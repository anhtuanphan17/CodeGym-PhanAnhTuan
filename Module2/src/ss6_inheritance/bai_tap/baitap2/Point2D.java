package ss6_inheritance.bai_tap.baitap2;

public class Point2D {
    public float x =0.0f;
    public float y= 0.0f;

    public Point2D(float x,float y){
        this.x=x;
        this.y=y;
    }

    public Point2D(){

    }

    public float getX(){
        return this.x;
    }
    public void setX(float x){
        this.x=x;
    }
    public float getY(){
        return this.y;
    }
    public void setY(float y){
        this.y=y;
    }
    public void setXY(float x,float y){
        this.x=x;
        this.y=y;
    }
    public float[] getXY(){
        float[] XY= {x,y};
        return XY;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
