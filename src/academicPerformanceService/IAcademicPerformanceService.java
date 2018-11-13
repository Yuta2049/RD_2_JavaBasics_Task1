package academicPerformanceService;

import data.Student;

public interface IAcademicPerformanceService {

    int getDaysToEndOfCurriculum(Student student);

    int getAverageMark(Student student);

    void printPossibilityOfExpulsion(Student student);

    void printListOfStudents(boolean sort);

    void printListOfStudentsPossibleWontBeExpelled();

}
