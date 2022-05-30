package ss6_inheritance.bai_tap.baitap3;

public class MovablePoint extends Point {
    public float xSpeed = 0.0f;
    public float ySpeed = 0.0f;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        this.x=super.getX();
        this.y=super.getY();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speed = {xSpeed, ySpeed};
        return speed;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")" +
                "MovablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    public float[] move() {
        setX(getX() + getXSpeed());
        setY(getY() + getYSpeed());
        return getXY();
    }


}
