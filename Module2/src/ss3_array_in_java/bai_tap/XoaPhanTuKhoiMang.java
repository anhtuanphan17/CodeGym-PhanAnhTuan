package ss3_array_in_java.bai_tap;
import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {

        int size;
        int x[];

        Scanner input = new Scanner(System.in);
        do{
            System.out.println("input the number of elements in array");
            size =input.nextInt();
            if(size>20){
                System.out.println("Size should not exceed 20");
            }

        }while(size>20);

        x=new int[size];

        for(int i=0;i<x.length;i++){
            System.out.println("input element "+ i + ":");
            x[i]=input.nextInt();
        }


        System.out.println("Type the number you want to remove");
        int removeNumber = input.nextInt();

        int index=0;
        for(int i=0;i<x.length;i++){
            if(removeNumber==x[i]){
                index=i;
            }
        }

        for(;index<x.length-1;index++){
            x[index]=x[index+1];

        }
        x[x.length-1]=0;

        System.out.println(Arrays.toString(x));


    }
}
