package ss14_sort_algorithm.bai_tap;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int [] list){
        for(int i=1;i<list.length;i++){
            int temp = list[i];
            int j = i-1;
            while(j>=0&&temp<list[j]){
                list[j+1]=list[j];
                j--;
            }
            list[j+1]=temp;
            System.out.println(Arrays.toString(list));
        }


    }

   static int [] list= {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void main(String[] args) {
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
