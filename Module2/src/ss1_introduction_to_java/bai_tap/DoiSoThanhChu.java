package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class DoiSoThanhChu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scan.nextInt();

        if(number>=0&&number<20){
            System.out.println(number0to19(number));
        }else if (number>19&&number<100){
            System.out.println(number20to99(number));
        }else{
            System.out.println("out of ability");
        }

    }


    public static String number0to19(int number) {
        String result = "";
        switch (number) {
            case 0:
                result = "Zero";
                break;
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            case 3:
                result = "Three";
                break;
            case 4:
                result = "Four";
                break;
            case 5:
                result = "Five";
                break;
            case 6:
                result = "Six";
                break;
            case 7:
                result = "Seven";
                break;
            case 8:
                result = "Eight";
                break;
            case 9:
                result = "Nine";
                break;
            case 10:
                result = "Tens";
                break;
            case 11:
                result = "Eleven";
                break;
            case 12:
                result = "Twelve";
                break;
            case 13:
                result = "Thirteen";
                break;
            case 14:
                result = "Fourteen";
                break;
            case 15:
                result = "Fifteen";
                break;
            case 16:
                result = "Sixteen";
                break;
            case 17:
                result = "Seventeen";
                break;
            case 18:
                result = "Eighteen";
                break;
            case 19:
                result = "Nineteen";
                break;

        }

        return result;
    }

    public static String number20to99(int number) {
        String result = "";
        int dozen = number / 10;
        int unit = number % 10;
        switch (dozen) {
            case 2:
                result = "Twenty ";
                break;
            case 3:
                result = "Thirty ";
                break;
            case 4:
                result = "Forty ";
                break;
            case 5:
                result = "Fifty ";
                break;
            case 6:
                result = "Sixty ";
                break;
            case 7:
                result = "Seventy ";
                break;
            case 8:
                result = "Eighty ";
                break;
            case 9:
                result = "Ninety ";
                break;
        }
        return result+=unit1to9(number);

    }

    public static String unit1to9(int number){
        int unit =number%10;
        String result ="";
        switch (unit) {
            case 0:
                result = "";
                break;
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            case 3:
                result = "Three";
                break;
            case 4:
                result = "Four";
                break;
            case 5:
                result = "Five";
                break;
            case 6:
                result = "Six";
                break;
            case 7:
                result = "Seven";
                break;
            case 8:
                result = "Eight";
                break;
            case 9:
                result = "Nine";
        }
        return result;

}

}


