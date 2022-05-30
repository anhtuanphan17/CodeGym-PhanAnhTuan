package ss15_exception_and_debug.thuc_hanh.number_format_exception;

import java.util.Scanner;

public class CalculateExample {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input x");
        int x = input.nextInt();
        System.out.println("input y");
        int y = input.nextInt();
        CalculateExample.calculate(x,y);



    }


    public static void calculate(int x,int y){
        Scanner input = new Scanner(System.in);
        try {
            int sum = x + y;
            int subtract = x - y;
            int multiple = x * y;
            int divide = x / y;
        }catch(Exception e){
        System.err.println("Error "+ e.getMessage());
        }



    }



}
