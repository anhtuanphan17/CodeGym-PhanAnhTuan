package ss3_array_in_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;


public class TinhTongCotXacDinh {
    public static void main(String[] args) {

        int[][] arr = new int[2][2];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                System.out.println(" input element at position" + i + "-" + j);
                arr[i][j] = input.nextInt();
            }

        }

        System.out.println(Arrays.toString(arr));

        int column;

        do {
            System.out.println("Which column do you want to sum");
            column = input.nextInt();
        } while (column < 0 && column > 2);


        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == column) {
                    sum += arr[i][column];

                }

            }



        }
        System.out.println("total column is: "+ sum);
    }
}
