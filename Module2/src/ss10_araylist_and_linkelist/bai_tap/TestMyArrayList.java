package ss10_araylist_and_linkelist.bai_tap;

public class TestMyArrayList {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public  Student(int id, String name) {
            this.id = id;
            this.name = name;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        Student student1 = new Student(12, "Tuan");
        Student student2 = new Student(12, "Huy");
        Student student3 = new Student(12, "Long");
        Student student4 = new Student(12, "Thanh");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);
        studentMyList.add(student4);


        for (int i = 0; i < studentMyList.size; i++) {
            System.out.println(studentMyList.elements[i]);
        }


    }
}
