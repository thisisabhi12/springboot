package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {

    @Id
    private Integer courseId;
    private Integer studentId;
    private Integer percentage;

    public Result() {
    }

    public Result(Integer courseId, Integer studentId ,Integer percentage) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.percentage = percentage;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}