package dataStorageService;

import data.Curriculum;
import data.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataStorageServiceFile implements IDataStorageService {
    
    @Override
    public void saveToStorageStudents(List<Student> students) {

        try (FileOutputStream fos = new FileOutputStream(new File("TestData.txt"));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            //for (Student currentStudent : students) {
            //    oos.writeObject(currentStudent);
            //}
            oos.writeObject(students);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> readFromStorageStudents() {

        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File("TestData.txt"));
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            //while ois.readObject()
            /*Student s1 = (Student) ois.readObject();
            Student s2 = (Student) ois.readObject();

            students.add(s1);
            students.add(s2);*/

            students = ((ArrayList<Student>) ois.readObject());

            /*Student student = null;
            do {
                student = (Student) ois.readObject();
                if (student != null) {
                    students.add(student);
                }
            } while (student != null);*/

            //List<String> lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
            //List<Student> students = Files.read .readAllLines(Paths.get("Students.txt"), StandardCharsets.UTF_8);


        }catch(Exception e){
            e.printStackTrace();
        }
        return students;
    }
}
