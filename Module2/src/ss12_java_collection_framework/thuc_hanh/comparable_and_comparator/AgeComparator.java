package ss12_java_collection_framework.thuc_hanh.comparable_and_comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().equals(o2.getName())) {
            return o1.getAge() - o2.getAge();
        }
        return 0;

    }
}