package vsu.kurs3.att1.task3.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Group")
class Group {

    private int id;
    private int number;
    private Course course;
    private Set<Student> students;

    public Group(){

    }

    public Group(int num, Course course, Set<Student> students){
        this.course = course;
        this.number = num;
        this.students = students;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourseID", nullable = false)
    public Course getCourse() {
        return course;
    }

    @Column(name = "GroupNum")
    public int getNumber() {
        return number;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "GroupID")    //*студенты* мапнуты через GroupID
    public Set<Student> getStudents() {
        return students;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(Course courseId) {
        this.course = course;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
