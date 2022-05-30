package ss11_dsa_stack_and_queue.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("input string you want to check");
        String inputString = input.nextLine();
        String [] splitString = inputString.split("");

        System.out.println(Arrays.toString(splitString));

        int first=0;
        int last= splitString.length-1;

        Boolean flag =true;

        while(first<last){
            if(!(splitString[first].equals(splitString[last]))){
                flag=false;
                break;
            }
            first++;
            last--;
        }

        if(flag){
            System.out.println("This is Palindrome");
        }else{
            System.out.println("not Palindrome");
        }

    }
}
