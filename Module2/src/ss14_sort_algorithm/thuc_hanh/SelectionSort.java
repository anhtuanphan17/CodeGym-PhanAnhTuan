package ss14_sort_algorithm.thuc_hanh;

import java.util.Arrays;

public class SelectionSort {

    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length-1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                double temp = list[i];
                list[i] = list[indexMin];
                list[indexMin] = temp;
            }
        }


    }

    public static void main(String[] args) {
        selectionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
