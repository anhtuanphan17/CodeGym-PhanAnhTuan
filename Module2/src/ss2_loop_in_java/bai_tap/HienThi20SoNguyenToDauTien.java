package ss2_loop_in_java.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("type number of prime number you want to display");
        int numberOfPrime = input.nextInt();
        int count = 0;
        int n = 2;
        String result ="";
        while (count <= numberOfPrime) {
            if (checkPrime(n)){
                count++;
                result+=n+ ",";

            }
            n++;

        }
        System.out.println("prime number is: "+ result);
    }
        public static boolean checkPrime ( int number){
            if (number < 2) {
                return false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }



