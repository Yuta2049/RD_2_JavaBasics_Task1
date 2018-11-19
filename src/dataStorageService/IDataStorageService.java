package dataStorageService;

import data.Student;

import java.util.List;

public interface IDataStorageService {

    void saveToStorageStudents(List<Student> students);

    List<Student> readFromStorageStudents();

    String getFilename();

}
