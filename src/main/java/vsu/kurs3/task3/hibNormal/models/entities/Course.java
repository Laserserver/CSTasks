package vsu.kurs3.task3.hibNormal.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long coursenum;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")    //*группы* мапнуты полем course
    private Set<Group> groups;

    public Course(){}


    public long getId(){ return this.id;}

    public long getCoursenum() { return coursenum; }

    public Set<Group> getGroups() { return groups; }


    public void setCoursenum(long coursenum) { this.coursenum = coursenum; }

    public void setId(long id) { this.id = id; }

    public void setGroups(Set<Group> groups) { this.groups = groups; }
}
