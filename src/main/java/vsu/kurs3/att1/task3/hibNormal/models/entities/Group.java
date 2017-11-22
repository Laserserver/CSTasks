package vsu.kurs3.att1.task3.hibNormal.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Group")
public class Group {

    private long id;

    private long number;

    private Course course;

    private Set<Student> students;

    public Group(){ }


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() { return id; }

    @ManyToOne(optional = false)
    @JoinColumn(name = "CourseID", referencedColumnName = "ID")
    public Course getCourse() { return course; }

    @Column(name = "GroupNum")
    public long getNumber() { return number; }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", targetEntity=Student.class)    //*студенты* мапнуты полем group
    public Set<Student> getStudents() { return students; }


    public void setId(long id) { this.id = id; }

    public void setCourseId(Course courseId) { this.course = course; }

    public void setNumber(long number) { this.number = number; }

    public void setStudents(Set<Student> students) { this.students = students; }
}
