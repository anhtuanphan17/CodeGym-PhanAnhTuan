package ss15_exception_and_debug.bai_tap;

import java.util.Scanner;

public class CheckTriangle {
    public static void main(String[] args) {

        boolean flag;
        do {
            flag = false;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("input x ");
                int x = scanner.nextInt();
                System.out.println("input y ");
                int y = scanner.nextInt();
                System.out.println("int z");
                int z = scanner.nextInt();
                checkTriangle(x, y, z);
            } catch (IllegalTriangleException e) {
                System.err.println(e.getMessage());
                flag =true;
            }catch (Exception e){
                System.out.println("loi khac");
                flag =true;
            }
        } while (flag);


    }

    public static void checkTriangle(int x, int y, int z) throws IllegalTriangleException {
        if ((x <= 0 || y <= 0 || z <= 0) || ((x + y) < z || (y + z) < x || (x + z) < y)) {
            throw new IllegalTriangleException("loi chuong trinh");
        }

    }


}
