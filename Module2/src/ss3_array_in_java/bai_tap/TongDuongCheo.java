package ss3_array_in_java.bai_tap;
import java.util.Arrays;
import java.util.Scanner;

public class TongDuongCheo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("input row ");
        int row = scanner.nextInt();
        System.out.println("input column");
        int col = row;
        int[][] arr = new int[row][col];
        int sum = 0;
                ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("input elements at position" + i + "-" + j );
                arr[i][j] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == i) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("sum is: " + sum);


    }
}
