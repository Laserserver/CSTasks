package vsu.kurs3.att1.task3.hibNormal.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Group")
public class Group {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "GroupNum")
    private long number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CourseID", referencedColumnName = "ID")
    private Course course;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", targetEntity=Student.class)    //*студенты* мапнуты полем group
    private Set<Student> students;

    public Group(){ }

    public Group(long num, Course course, Set<Student> students){
        this.course = course;
        this.number = num;
        this.students = students;
    }

    public long getId() { return id; }

    public Course getCourse() { return course; }

    public long getNumber() { return number; }

    public Set<Student> getStudents() { return students; }


    public void setId(long id) { this.id = id; }

    public void setCourseId(Course courseId) { this.course = course; }

    public void setNumber(long number) { this.number = number; }

    public void setStudents(Set<Student> students) { this.students = students; }
}
