package ss17_binary_file_and_serialization.thuc_hanh.read_and_write_studentlist_to_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void writeToFile(String path, List<Student> students) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Student> readFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("C:\\Users\\Dell\\Desktop\\CODEGYM\\Module2\\src\\ss17_binary_file_and_serialization\\thuc_hanh\\read_and_write_studentlist_to_binary_file\\StudentList.dat", students);
        List<Student> listStudent = readFromFile("src/ss17_binary_file_and_serialization/thuc_hanh/read_and_write_studentlist_to_binary_file/StudentList.dat");

        for(Student std : students){
            System.out.println(std);
        }
    }


}
