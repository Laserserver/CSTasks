package vsu.kurs3.task3.hibNormal.models.dto;

import java.util.Set;

public class GroupDTO {

    private long id;

    private long number;

    private CourseDTO course;

    private Set<StudentDTO> students;

    public GroupDTO(){ }


    public long getId() { return id; }

    public CourseDTO getCourse() { return course; }

    public long getNumber() { return number; }

    public Set<StudentDTO> getStudents() { return students; }


    public void setId(long id) { this.id = id; }

    public void setCourseId(CourseDTO courseId) { this.course = course; }

    public void setNumber(long number) { this.number = number; }

    public void setStudents(Set<StudentDTO> students) { this.students = students; }
}
