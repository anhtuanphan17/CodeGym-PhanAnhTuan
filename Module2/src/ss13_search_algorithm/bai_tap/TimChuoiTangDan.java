package ss13_search_algorithm.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class TimChuoiTangDan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();

        LinkedList<Character> list = new LinkedList<>();

        list.add(string.charAt(0));

        for (int j = 1; j < string.length(); j++) {
            if (string.charAt(j) > list.getLast()) {
                list.add(string.charAt(j));
            }
        }

        for (Character li : list) {
            System.out.print(li);
        }
        System.out.println();
    }
}


