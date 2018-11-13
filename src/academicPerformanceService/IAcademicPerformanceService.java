package academicPerformanceService;

import data.Student;

public interface IAcademicPerformanceService {

    long getDaysToEndOfCurriculum(Student student);

    double getAverageMark(Student student);

    void printPossibilityOfExpulsion(Student student);

    void printListOfStudents(boolean sort);

    void printListOfStudentsPossibleWontBeExpelled();

}
