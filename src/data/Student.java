package data;

import data.Curriculum;

import java.time.LocalDate;
import java.util.List;

public class Student implements java.io.Serializable {

    private long id;
    private String firstName;
    private String secondName;
    private Curriculum curriculum;
    private LocalDate start_date;
    private List<Integer> marks;

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public Student(int id, String firstName, String secondName, Curriculum curriculum, LocalDate start_date) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.curriculum = curriculum;
        this.start_date = start_date;
    }
}
