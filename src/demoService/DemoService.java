package demoService;

import academicPerformanceService.AcademicPerformanceService;
import academicPerformanceService.IAcademicPerformanceService;
import data.Course;
import data.Curriculum;
import data.Student;
import dataStorageService.DataStorageServiceFile;
import dataStorageService.IDataStorageService;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoService implements IDemoService {


    @Override
    public void showDemo() {

        // Инициализируем список студентов
        List<Student> students = new ArrayList<>();

        // Проверяем, есть ли файл с сохранненными тестовыми данными
        if (!new File("TestData.txt").isFile()) {

            students = generateTestData();
            IDataStorageService dataStorageService = new DataStorageServiceFile();
            dataStorageService.saveToStorageStudents(students);

        } else {

            IDataStorageService dataStorageService = new DataStorageServiceFile();
            students = dataStorageService.readFromStorageStudents();

        }

        IAcademicPerformanceService academicPerformanceService = new AcademicPerformanceService();
/*



        // Сохраним в файл программы

        //List<Curriculum> curriculums = new ArrayList<>();
        /*
        curriculums.add(curriculumJ2EE);
        curriculums.add(curriculumJava);
        */

//        IDataStorageService dataStorageService = new DataStorageServiceFile();
        /*
        dataStorageService.saveToStorageCurriculums(curriculums);

*/

        // Сохраним в файл студентов
        //dataStorageService.saveToStorageStudents(students);


        // Прочитаем
        //curriculums = dataStorageService.readFromStorageCurriculums();
//        students = dataStorageService.readFromStorageStudents();



        // ТУТ САМ ВЫВОД

        for (Student currentStudent : students) {
            System.out.println("Студент: "+currentStudent.getFirstName()+" "+currentStudent.getSecondName()+
                    " осталось учиться: "+ academicPerformanceService.getDaysToEndOfCurriculum(currentStudent));
        }

        for (Student currentStudent : students) {
            System.out.println("Студент: "+currentStudent.getFirstName()+" "+currentStudent.getSecondName()+
                    " средний балл: "+ academicPerformanceService.getAverageMark(currentStudent));
        }

        for (Student currentStudent : students) {
            System.out.println("Студент: "+currentStudent.getFirstName()+" "+currentStudent.getSecondName()+
                    " возможность отчисления: "+ academicPerformanceService.getPossibilityOfExpulsion(currentStudent));
        }


        System.out.println();
        System.out.println("Отсортируем список по среднему баллу");
        academicPerformanceService.getListOfStudentsSortedByAverageMark(students);

        for (Student currentStudent : students) {
            System.out.println("Студент: "+currentStudent.getFirstName()+" "+currentStudent.getSecondName()+
                    " средний балл: "+ academicPerformanceService.getAverageMark(currentStudent));
        }


        System.out.println();
        System.out.println("Отсортируем список по времени до окончания обучения");
        academicPerformanceService.getListOfStudentsSortedByDaysToEndOfCurriculum(students);

        for (Student currentStudent : students) {
            System.out.println("Студент: "+currentStudent.getFirstName()+" "+currentStudent.getSecondName()+
                    " время до окончания обучения: "+ academicPerformanceService.getDaysToEndOfCurriculum(currentStudent));
        }

    }

    @Override
    public List<Student> generateTestData() {

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
                LocalDate.of(2018, Month.JUNE, 1)));
                //Stream.of(3, 4, 2, 5, 3, 3).collect(Collectors.toList())));

        students.add(new Student(2, "Petrov", "Petr", curriculumJava,
                LocalDate.of(2018, Month.AUGUST, 1)));
                //Stream.of(4, 5, 3, 2, 3, 3, 5, 5).collect(Collectors.toList())));

        IAcademicPerformanceService academicPerformanceService = new AcademicPerformanceService();

        // Генерируем оценки
        for (Student currentStudent : students) {

            List<Integer> marks = new ArrayList<>();
            for (int i=0; i<academicPerformanceService.getTimeOfEducationInDays(currentStudent); i++) {
                int mark = (int) (Math.random() * (4)) + 2;
                marks.add(mark);
            }
            currentStudent.setMarks(marks);
        }

        return students;

    }
}
