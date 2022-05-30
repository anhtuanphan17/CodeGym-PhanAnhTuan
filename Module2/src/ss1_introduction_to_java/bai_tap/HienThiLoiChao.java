package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scan.nextLine();
        System.out.printf("Hello: %s",name);

    }
}
