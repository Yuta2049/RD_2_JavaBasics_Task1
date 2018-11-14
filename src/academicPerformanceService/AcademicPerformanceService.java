package academicPerformanceService;

import data.Curriculum;
import data.Student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

public class AcademicPerformanceService implements IAcademicPerformanceService {

    @Override
    public long getTimeOfEducationInDays(Student student) {

        double duration = 0;
        Curriculum curriculum = student.getCurriculum();
        if (curriculum != null) {
            duration = curriculum.getCurriculumDuration()/8;
        }

        long timeOfEducation = ChronoUnit.DAYS.between(student.getStart_date(), LocalDate.now());

        return (long) Math.ceil(Double.min(duration, timeOfEducation));

    }

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
    public boolean getPossibilityOfExpulsion(Student student) {

        if (getAverageMark(student) >= 4.5) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public List getListOfStudentsSortedByAverageMark(List<Student> students) {

        students.sort(Comparator.comparing(this::getAverageMark));
        return students;
    }

    @Override
    public List getListOfStudentsSortedByDaysToEndOfCurriculum(List<Student> students) {

        students.sort(Comparator.comparing(this::getDaysToEndOfCurriculum));
        return students;
    }

    @Override
    public void printListOfStudentsPossibleWontBeExpelled() {

    }
}
