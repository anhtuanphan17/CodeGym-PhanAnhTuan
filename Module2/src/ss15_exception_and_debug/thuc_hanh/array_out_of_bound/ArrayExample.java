package ss15_exception_and_debug.thuc_hanh.array_out_of_bound;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayExample {

    public Integer[] createArray() {
        Random random = new Random();
        Integer[] array = new Integer[100];
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(100);
//            System.out.print(array[i] + " ");
        }
        return array;


    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer [] arr = arrayExample.createArray();
        System.out.println(Arrays.toString(arr));

        Scanner input = new Scanner(System.in);
        System.out.println("\ninput check number");
        int x = input.nextInt();
        try{
            System.out.println("gia tri cua phan tu co chi so " +x + "la "+ arr[x]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("chi so vuot qua gioi han cua mang");
        }



    }


}
