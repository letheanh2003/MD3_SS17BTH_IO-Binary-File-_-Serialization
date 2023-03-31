package BTH2_DocVaGhiFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String PATH_FILE = "E:\\code_md3\\SS17_BTH_IO Binary File _ Serialization\\src\\BTH2_DocVaGhiFile\\student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Lê Thế Anh", "Bắc Ninh"));
        students.add(new Student(2, "Mai Anh Khoa", "Kon Tum"));
        students.add(new Student(3, "Nguyễn Phúc Thắng", "Nghệ An"));
        students.add(new Student(4, "Nguyễn Đức Minh", "Bắc Giang"));
        students.add(new Student(5, "Thái Phương Nam", "Hà Tĩnh"));

        writeToFile(PATH_FILE, students);
        List<Student> studentDataFromFile = readDataFromFile(PATH_FILE);
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }

    private static void writeToFile(String path, List<Student> students) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> readDataFromFile(String path) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
