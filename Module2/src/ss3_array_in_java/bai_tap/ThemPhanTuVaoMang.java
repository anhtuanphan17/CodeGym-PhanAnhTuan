package ss3_array_in_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {

        int size;
        int x[];

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("input the number of elements in array");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }

        } while (size > 20);

        x = new int[size];

        for (int i = 0; i < x.length; i++) {
            System.out.println("input element " + i + ":");
            x[i] = input.nextInt();
        }

        System.out.println("input position you want to add into array");
        int index = input.nextInt();

        System.out.println("Input value you want to add into array");
        int valueAdded = input.nextInt();

        int[] newArray = new int[x.length + 1];

        for (int j = 0; j < newArray.length; j++) {
            if (j < index) {
                newArray[j] = x[j];
                System.out.print(newArray[j]);
            } else if(j==index) {
                newArray[index] = valueAdded;
                System.out.print(newArray[index]);
            }else{
                newArray[j]=x[j-1];
                System.out.print(newArray[j]);
            }
        }


    }
}

