package ss3_array_in_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {

        int[][] arr = new int[2][2];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                System.out.println(" input element at position" + i + "-" + j);
                arr[i][j] = input.nextInt();
            }

        }

        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Max number is: "+ max);

    }
}
