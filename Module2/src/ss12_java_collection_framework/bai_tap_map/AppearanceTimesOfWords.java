package ss12_java_collection_framework.bai_tap_map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AppearanceTimesOfWords {
    public static void main(String[] args) {

        String string = "Hello hello Hello world World world ";

        String[] newString = string.toLowerCase().split(" ");
        System.out.println(Arrays.toString(newString));

        Map<String, Integer> treeMap = new TreeMap<>();

        treeMap.put(newString[0], 1);

        for (int i = 1; i < newString.length; i++) {
            int count = 1;
            if (treeMap.containsKey(newString[i])) {
                count = treeMap.get(newString[i]) + 1;
                treeMap.put(newString[i], count);
            } else {
                treeMap.put(newString[i], count);
            }

        }

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry);
        }


    }


}
