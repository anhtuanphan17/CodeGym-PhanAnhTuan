package ss13_search_algorithm.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class ChuoiLienTiepCoDoDaiLonNhat {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter string: ");
        String string = input.nextLine();
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            if (list.size() >= 1 && string.charAt(i) <= list.getLast()) {
                list.clear();
            }
            list.add(string.charAt(i));

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }

    for(Character m:max){
        System.out.print(m);
    }
    }

}
