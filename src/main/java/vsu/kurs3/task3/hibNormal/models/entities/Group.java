package vsu.kurs3.task3.hibNormal.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups ")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    private long number;

    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name="courseid")
    private Course course;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)    //*студенты* мапнуты полем group
    private List<Student> students;

    public Group(){ }


    public long getId() { return id; }

    public Course getCourse() { return course; }

    public long getNumber() { return number; }

    public List<Student> getStudents() { return students; }


    public void setId(long id) { this.id = id; }

    public void setCourse(Course course) { this.course = course; }

    public void setNumber(long number) { this.number = number; }

    public void setStudents(List<Student> students) { this.students = students; }
}
