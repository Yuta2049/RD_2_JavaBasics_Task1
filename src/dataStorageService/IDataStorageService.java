package dataStorageService;

import data.Curriculum;
import data.Student;

import java.util.List;

public interface IDataStorageService {

    /*void saveToStorageCurriculums(List<Curriculum> curriculums);

    List<Curriculum> readFromStorageCurriculums();*/

    void saveToStorageStudents(List<Student> students);

    List<Student> readFromStorageStudents();

}
