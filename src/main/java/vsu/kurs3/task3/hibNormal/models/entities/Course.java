package vsu.kurs3.task3.hibNormal.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long coursenum;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)    //*группы* мапнуты полем course
    private List<Group> groups;

    public Course(){}


    public long getId(){ return this.id;}

    public long getCoursenum() { return coursenum; }

    public List<Group> getGroups() { return groups; }

    public void setCoursenum(long coursenum) { this.coursenum = coursenum; }

    public void setId(long id) { this.id = id; }

    public void setGroups(List<Group> groups) { this.groups = groups; }
}
