package ss2_loop_in_java.bai_tap;

import java.util.Scanner;

public class HienThiSoNguyenToNhoHon100 {
    public static void main(String[] args) {


        int number = 0;
        int n=0;
        String result = "";
        while (n < 100) {
            if (checkPrime(n)) {
                result+=n+",";

            }
            n++;
        }

        System.out.println("prime number which is lower than 100 is: "+ result);



    }


        public static boolean checkPrime (int n){
            if (n < 2) {
                return false;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if ((n & i) == 0) {
                        return false;
                    }
                }
                return true;
            }

        }

    }
