package ss12_java_collection_framework.thuc_hanh.comparable_and_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Kien", 100, "HT");
        Student student1 = new Student("Kien", 26, "HN");
        Student student2 = new Student("Kien", 38, "HT");
        Student student3 = new Student("Tung", 38, "HT");

        List<Student> lists = new ArrayList<>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);

        Collections.sort(lists);

        for (Student st : lists) {
            System.out.println(st.toString());
        }

        System.out.println("after sort age");
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists);
        Collections.sort(lists,ageComparator);

        for (Student st : lists) {
            System.out.println(st.toString());
        }

    }
}
