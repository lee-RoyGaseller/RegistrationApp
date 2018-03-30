import java.util.Objects;

public class Course {
    private String dept;
    private Integer courseNumber;
    private Integer hours;

    public Course(){

    }

    public Course(String dept, Integer courseNumber, Integer hours) {
        this.dept = dept;
        this.courseNumber = courseNumber;
        this.hours = hours;
    }


    public String getDept() {
        return dept;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public Integer getHours() {
        return hours;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getDept(), course.getDept()) &&
                Objects.equals(getCourseNumber(), course.getCourseNumber()) &&
                Objects.equals(getHours(), course.getHours());
    }


    @Override
    public String toString() {
        return "Course(" + "dept='" + dept + '\'' + ", courseNumber=" + courseNumber + ", hours=" + hours + ')';
    }
}
