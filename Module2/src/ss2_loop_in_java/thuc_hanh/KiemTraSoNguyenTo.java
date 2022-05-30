package ss2_loop_in_java.thuc_hanh;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("type the number you want to check");
        float number = scan.nextFloat();
        if (number < 2) {
            System.out.println(number + " is not a prime");
        } else {
            int i = 2;
            boolean check = true;
            while (i < Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;

            }
            if (check) {
                System.out.println(number + " is a prime");
            } else {
                System.out.println(number + " is not a prime");
            }


        }


    }



}