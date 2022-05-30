package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
            int tyGia = 23000;
        System.out.println("Nhap vao so tien USD can doi sang VND");
        float soTienUSD =scan.nextFloat();
        float sauKhiDoi =soTienUSD*tyGia;

        System.out.println("Sau khi doi tien la: " + sauKhiDoi);







    }
}
