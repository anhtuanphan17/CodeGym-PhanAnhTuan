package ss3_array_in_java.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class DaoNguocMang {
    public static void main(String[] args) {

        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("input the size of array");
            size = scanner.nextInt();
            if(size>20){
                System.out.println("Size does not exceed 20");
            }

        }while(size>20);

        array = new int[size];
        for(int i=0;i<array.length;i++){
            System.out.println("Enter element "+ i);
           array[i] = scanner.nextInt();
        }

//        for(int i=0;i<array.length;i++){
//            System.out.print(array[i]);
//        }

        int first =0;
        int last = array.length-1;
        while(first<last){
            int temp;
            temp = array[first];
            array[first]=array[last];
            array[last]=temp;
            first++;
            last--;
        }
        System.out.println("Mang sau khi dao nguoc la:"+ Arrays.toString(array));



    }
}
