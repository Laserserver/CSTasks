package vsu.kurs3.task3.hibNormal.models.dto;

import java.util.List;

public class GroupDTO {

    private long id;

    private long number;

    private CourseDTO course;

    private List<StudentDTO> students;

    public GroupDTO(){ }


    public long getId() { return id; }

    public CourseDTO getCourse() { return course; }

    public long getNumber() { return number; }

    public List<StudentDTO> getStudents() { return students; }


    public void setId(long id) { this.id = id; }

    public void setCourse(CourseDTO course) { this.course = course; }

    public void setNumber(long number) { this.number = number; }

    public void setStudents(List<StudentDTO> students) { this.students = students; }

    public void addStudent(StudentDTO student){
        students.add(student);
    }
}
