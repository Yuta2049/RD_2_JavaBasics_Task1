package data;

import java.util.List;

public class Curriculum implements java.io.Serializable {

    private long id;
    private String name;
    private List<Course> courses;

    public Curriculum(long id, String name, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(List<Course> course) {
        this.courses = course;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List getCourses() {
        return courses;
    }

    public int getCurriculumDuration() {
        int duration = 0;
        for (Course currentCourse : courses) {
            duration += currentCourse.getDuration();
        }
        return duration;
    }

}
