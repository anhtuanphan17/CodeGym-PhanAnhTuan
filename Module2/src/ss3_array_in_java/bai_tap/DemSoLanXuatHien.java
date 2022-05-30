package ss3_array_in_java.bai_tap;
import java.util.Scanner;

public class DemSoLanXuatHien {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        System.out.println("input string: ");
        String str = scanner.nextLine();
        int count = 0;
        System.out.println("input character you want to check: ");
        char chars = scanner.next().charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chars) {
                count++;
            }
        }
        System.out.println("repeated time of " + chars + " is " + count);

    }
}
