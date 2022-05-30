package ss2_loop_in_java.bai_tap;

import java.util.Scanner;

public class HienThiCacHinh {
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 4) {
            Scanner input = new Scanner(System.in);

            System.out.println("menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter number of geometry which you want to print");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 20; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle ");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }

                    for (int i = 1; i <= 5; i++) {
                        for (int k = 4; k >= i; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }

                    for (int i = 1; i <= 5; i++) {
                        for (int j = 5; j >= i; j--) {
                            System.out.print("*");
                        }
                        for (int k = 1; k < i; k++) {
                            System.out.print(" ");
                        }
                        System.out.println("");
                    }

                    for (int i = 1; i <= 5; i++) {
                        for (int k = 1; k < i; k++) {
                            System.out.print(" ");
                        }
                        for (int j = 5; j >= i; j--) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("Print isosceles triangle ");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 4; j >= i; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i * 2 - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice");
            }

        }
    }
}
