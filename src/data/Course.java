package data;

public class Course {

    private long id;
    private int duration;
    private String courseName;

    public Course(long id, String courseName, int duration) {
        this.id = id;
        this.duration = duration;
        this.courseName = courseName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getCourseName() {
        return courseName;
    }
}
