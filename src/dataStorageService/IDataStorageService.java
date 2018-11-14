package dataStorageService;

import data.Student;

import java.util.List;

public interface IDataStorageService {

    void saveToStorage(List<Student> students);

    List<Student> readeFromStorage();

}
