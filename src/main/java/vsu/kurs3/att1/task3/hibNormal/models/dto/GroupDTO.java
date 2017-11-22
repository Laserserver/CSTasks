package vsu.kurs3.att1.task3.hibNormal.models.dto;

import java.util.Set;

public class GroupDTO {

    private long id;

    private long number;

    private CourseDTO course;

    private Set<StudentDTO> students;

    public GroupDTO(){ }

    public GroupDTO(long num, CourseDTO course, Set<StudentDTO> students){
        this.course = course;
        this.number = num;
        this.students = students;
    }

    public long getId() { return id; }

    public CourseDTO getCourse() { return course; }

    public long getNumber() { return number; }

    public Set<StudentDTO> getStudents() { return students; }


    public void setId(long id) { this.id = id; }

    public void setCourseId(CourseDTO courseId) { this.course = course; }

    public void setNumber(long number) { this.number = number; }

    public void setStudents(Set<StudentDTO> students) { this.students = students; }
}
