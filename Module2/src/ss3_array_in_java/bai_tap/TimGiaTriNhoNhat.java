package ss3_array_in_java.bai_tap;

import java.util.Scanner;

public class TimGiaTriNhoNhat {
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

        int min = x[0];
        for(int i=1;i<x.length;i++){
            if(min>x[i]){
                min=x[i];
            }

        }
        System.out.println("min is: "+ min);



    }
}
