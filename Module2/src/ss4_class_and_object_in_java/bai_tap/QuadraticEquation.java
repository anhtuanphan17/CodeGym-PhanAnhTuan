package ss4_class_and_object_in_java.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - (4 * this.a * this.c);
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt(Math.pow(this.b, 2)) - 4 * this.a * this.c) / 2 * this.a;
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(Math.pow(this.b, 2)) - 4 * this.a * this.c) / 2 * this.a;
    }

    public double getSameRoot() {
        return -this.b / this.a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Calculate the quadratic equation: ax2+bx+c=0");
        System.out.println("input a");
        double a = input.nextDouble();
        System.out.println("input b");
        double b = input.nextDouble();
        System.out.println("input c");
        double c = input.nextDouble();

        QuadraticEquation phuongTrinhBac2 = new QuadraticEquation(a, b, c);
        if (phuongTrinhBac2.getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if (phuongTrinhBac2.getDiscriminant() == 0) {
            System.out.println("The equation have same root is: " + phuongTrinhBac2.getSameRoot());
        } else {
            System.out.println("The equation have two root is: " + phuongTrinhBac2.getRoot1() + " and " + phuongTrinhBac2.getRoot2());
        }


    }

}
