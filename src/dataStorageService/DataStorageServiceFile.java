package dataStorageService;

import data.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorageServiceFile implements IDataStorageService {

    private static final String filename = "TestData.txt";

    @Override
    public void saveToStorageStudents(List<Student> students) {

        try (FileOutputStream fos = new FileOutputStream(new File(filename));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> readFromStorageStudents() {

        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filename));
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            try {
                students = ((ArrayList<Student>) ois.readObject());
            } catch (ClassCastException e) {
                System.out.println("Не удалось прочитать тестовые данные из файла");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public String getFilename() {
        return filename;
    }
}
