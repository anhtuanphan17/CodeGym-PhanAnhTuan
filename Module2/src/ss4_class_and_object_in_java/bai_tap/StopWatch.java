package ss4_class_and_object_in_java.bai_tap;

import javax.imageio.stream.ImageInputStream;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;


public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long startTime(){
    return this.startTime=System.currentTimeMillis();
    }

    public long endTime(){
        return this.endTime=System.currentTimeMillis();
    }

    public long elapsedTime(){
       return this.endTime-this.startTime;
    }


    public static void selectionSort(int[] arr,int size){
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(arr[i]<arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=arr[i];
                }
            }
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        int size=10000;
        int[]arr = new int [size];
        for(int i =0;i<size;i++){
            arr[i]=random.nextInt();
        }

        StopWatch stopWatch1 = new StopWatch();

        System.out.println("start time is: "+ stopWatch1.startTime());
        selectionSort(arr, size);
        System.out.println("end time is: " + stopWatch1.endTime()) ;

        System.out.println("total elapsed time is: " + stopWatch1.elapsedTime());


    }



}