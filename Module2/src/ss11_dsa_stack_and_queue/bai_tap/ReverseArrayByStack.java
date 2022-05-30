package ss11_dsa_stack_and_queue.bai_tap;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArrayByStack {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int[] newArray = new int[array.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        while (!stack.isEmpty()) {
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = stack.pop();
            }

        }
        System.out.println("Array after reversed is: "+ Arrays.toString(newArray));
    }

}
