package vsu.kurs3.task3.hibNormal.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    private long number;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="coursenum")
    private Course course;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")    //*студенты* мапнуты полем group
    private Set<Student> students;

    public Group(){ }


    public long getId() { return id; }

    public Course getCourse() { return course; }

    public long getNumber() { return number; }

    public Set<Student> getStudents() { return students; }


    public void setId(long id) { this.id = id; }

    public void setCourse(Course course) { this.course = course; }

    public void setNumber(long number) { this.number = number; }

    public void setStudents(Set<Student> students) { this.students = students; }
}
