package exam_c11.utils;

import java.util.Scanner;

public class RegexData {
    public static final String REGEX_MA_BENH_AN = "^[B]{1}[A]{1}[-]{1}[0-9]{3}";
    public static final String REGEX_PRODUCT_CODE = "(M)[-][\\d]{2}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";


    static Scanner scanner = new Scanner(System.in);

    public static String regexString(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }
}
