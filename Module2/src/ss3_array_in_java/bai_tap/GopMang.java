package ss3_array_in_java.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {

    int []arr1 = {1,2,3,4,5};
    int []arr2 = {9,8,7,6};
    int []arr3 =new int[arr1.length+arr2.length];

    for(int i=0;i<arr1.length;i++){
        arr3[i]=arr1[i];
    }
    for(int j=0;j<arr2.length;j++){
        arr3[(arr1.length-1)+j]=arr2[j];
    }

        System.out.println(Arrays.toString(arr3));

    }
}
