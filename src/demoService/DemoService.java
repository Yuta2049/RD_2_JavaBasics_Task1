package demoService;

import academicPerformanceService.AcademicPerformanceService;
import academicPerformanceService.IAcademicPerformanceService;
import data.Course;
import data.Curriculum;
import data.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoService implements IDemoService {


    @Override
    public void showDemo() {

        // ЗАПОЛНЯЕМ НАЧАЛЬНЫЕ ДАННЫЕ

        // Добавим программы

        Curriculum curriculumJ2EE = new Curriculum(1, "J2EE Developer",
            Stream.of(
                new Course(1L, "Технология Java Servlets", 16),
                new Course(2L, "Struts Framework", 24),
                new Course(3L, "Spring Framework", 48),
                new Course(4L, "Hibernate", 20)).collect(Collectors.toList())
        );


        Curriculum curriculumJava = new Curriculum(1, "Java Developer",
                Stream.of(
                        new Course(1L, "Обзор технологий Java", 8),
                        new Course(1L, "Библиотека JFC/Swing", 16),
                        new Course(2L, "Технология JDBC", 16),
                        new Course(3L, "Технология JAX", 52),
                        new Course(4L, "Библиотеки commons", 44)).collect(Collectors.toList())
        );


        // Инициализируем список студентов
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Ivanov", "Ivan", curriculumJ2EE,
                LocalDate.of(2018, Month.JUNE, 1),
                Stream.of(3, 4, 2, 5, 3, 3).collect(Collectors.toList())));

        students.add(new Student(2, "Petrov", "Petr", curriculumJava,
                LocalDate.of(2018, Month.AUGUST, 1),
                Stream.of(4, 5, 3, 2, 3, 3, 5, 5).collect(Collectors.toList())));


        // ТУТ САМ ВЫВОД

        IAcademicPerformanceService academicPerformanceService = new AcademicPerformanceService();
        for (Student currentStudent : students) {
            System.out.println("Студент: "+currentStudent.getFirstName()+" "+currentStudent.getSecondName()+
                    " осталось учиться: "+ academicPerformanceService.getDaysToEndOfCurriculum(currentStudent));
        }

        for (Student currentStudent : students) {
            System.out.println("Студент: "+currentStudent.getFirstName()+" "+currentStudent.getSecondName()+
                    " средний балл: "+ academicPerformanceService.getAverageMark(currentStudent));
        }

    }
}
