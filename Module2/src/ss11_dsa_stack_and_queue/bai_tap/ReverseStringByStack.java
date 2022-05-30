package ss11_dsa_stack_and_queue.bai_tap;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStringByStack {
    public static void main(String[] args) {

        String string  = "Hello World";

        Stack<String> stack = new Stack<>();

        String [] newString= string.split(" ");

//        System.out.println(Arrays.toString(newString));

        String result ="";
        for (String str:newString) {
           stack.push(str);
        }

        System.out.println(stack);

       while(!stack.isEmpty()){
           int size=stack.size();
           for (int i=0;i<size;i++) {
           result+= stack.pop() +" ";
           }


       }
        System.out.println(result);

    }

}
