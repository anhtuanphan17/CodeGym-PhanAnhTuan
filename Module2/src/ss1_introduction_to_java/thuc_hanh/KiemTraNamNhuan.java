package ss1_introduction_to_java.thuc_hanh;
import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
        System.out.println("Nhap vao nam can kiem tra");
        int year = scan.nextInt();

        if((year%4==0&&year%100!=0)||year%400==0){

            System.out.printf("%d la nam nhuan",year);
        }else{
            System.out.printf("%d khong phai la nam nhuan",year);
        }



    }
}
