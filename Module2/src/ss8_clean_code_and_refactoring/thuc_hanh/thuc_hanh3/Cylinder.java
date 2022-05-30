package ss8_clean_code_and_refactoring.thuc_hanh.thuc_hanh3;

public class Cylinder {
    public static double getVolume(int height,int radius) {
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        return baseArea *height + 2 * perimeter;

    }

    public static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }

    public static double getPerimeter(int radius) {
        return 2 * Math.PI * radius;
    }
}
