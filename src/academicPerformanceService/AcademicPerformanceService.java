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

        int duration = 0;
        Curriculum curriculum = student.getCurriculum();
        if (curriculum != null) {
            duration = (int) Math.ceil(curriculum.getCurriculumDuration() / (double) 8);
        }

        long timeOfEducation = ChronoUnit.DAYS.between(student.getStart_date(), LocalDate.now()) + 1;

        return (long) Math.ceil(Double.min(duration, timeOfEducation));

    }

    @Override
    public long getDaysToEndOfCurriculum(Student student) {

        int duration = 0;
        Curriculum curriculum = student.getCurriculum();
        if (curriculum != null) {
            duration = (int) Math.ceil(curriculum.getCurriculumDuration() / (double) 8);
        }

        //System.out.println("Продолжительность: "+duration);

        long timeOfEducation = ChronoUnit.DAYS.between(student.getStart_date(), LocalDate.now()) + 1;

        //System.out.println("timeOfEducation: "+timeOfEducation);

        // Дней до окончания программы
        //return Math.max(duration - timeOfEducation, 0);

        return Math.max(duration - timeOfEducation, 0);
    }

    @Override
    public double getAverageMark(Student student) {
        return (double) Math.round(student.getMarks().stream().mapToInt(Integer::intValue).sum() / (double) student.getMarks().size() * 100d) / 100;
    }

    @Override
    public boolean getPossibilityOfExpulsion(Student student) {
        return (getAverageMark(student) < 4.5);
    }

    @Override
    public List getListOfStudentsSortedByAverageMark(List<Student> students) {
        students.sort(Comparator.comparing(this::getAverageMark));
        return students;
    }

    @Override
    public List getListOfStudentsSortedByDaysToEndOfCurriculum(List<Student> students) {
        students.sort(Comparator.comparing(this::getDaysToEndOfCurriculum).reversed());
        return students;
    }

    @Override
    public boolean StudentPossibleWontBeExpelled(Student student) {

        long quantityOfTheDays = getDaysToEndOfCurriculum(student) + student.getMarks().size();

        long sumOfMarks = student.getMarks().stream().mapToInt(Integer::intValue).sum() + getDaysToEndOfCurriculum(student) * 5;

        //System.out.println("Гипотетический средний балл: "+(double) sumOfMarks/quantityOfTheDays);

        return (double) sumOfMarks / quantityOfTheDays > 4.5;
    }
}
