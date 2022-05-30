package ss11_dsa_stack_and_queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("input decimal number you want to convert to binary number: ");
        int inputNumber=input.nextInt();

        Stack stack =new Stack();

        String result="";


        while(inputNumber>0){
            stack.push(inputNumber%2);
            inputNumber=inputNumber/2;
        }


        int size = stack.size();

        for(int i=0;i<size;i++){
            result+=stack.pop();
        }

        System.out.println("Binanry number is: " + result);


    }

}
