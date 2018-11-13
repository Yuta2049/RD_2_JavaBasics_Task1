package academicPerformanceService;

import data.Curriculum;
import data.Student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AcademicPerformanceService implements IAcademicPerformanceService {

    @Override
    public long getDaysToEndOfCurriculum(Student student) {

        int duration = 0;
        Curriculum curriculum = student.getCurriculum();
        if (curriculum != null) {
            duration = curriculum.getCurriculumDuration()/8;
        }

        System.out.println("Продолжительность: "+duration);

        long timeOfEducation = ChronoUnit.DAYS.between(student.getStart_date(), LocalDate.now());

        System.out.println("Сейчас: "+LocalDate.now());
        System.out.println("Старт. дата: "+student.getStart_date());
        System.out.println("timeOfEducation: "+timeOfEducation);


        // Дней до окончания программы
        return duration - timeOfEducation;
    }

    @Override
    public double getAverageMark(Student student) {
        return student.getMarks().stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    @Override
    public void printPossibilityOfExpulsion(Student student) {

        

    }

    @Override
    public void printListOfStudents(boolean sort) {

    }

    @Override
    public void printListOfStudentsPossibleWontBeExpelled() {

    }
}
