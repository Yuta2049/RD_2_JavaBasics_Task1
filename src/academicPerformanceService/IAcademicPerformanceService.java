package academicPerformanceService;

import data.Student;

import java.util.List;

public interface IAcademicPerformanceService {

    long getTimeOfEducationInDays(Student student);

    long getDaysToEndOfCurriculum(Student student);

    double getAverageMark(Student student);

    boolean getPossibilityOfExpulsion(Student student);

    List getListOfStudentsSortedByAverageMark(List<Student> students);

    List getListOfStudentsSortedByDaysToEndOfCurriculum(List<Student> students);

    void printListOfStudentsPossibleWontBeExpelled();

}
