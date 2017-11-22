package vsu.kurs3.att1.task3.hibNormal.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Course")
public class Course {

    private long id;

    private long number;

    private Set<Group> groups;

    public Course(){}


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId(){ return this.id;}

    @Column(name = "CourseNum", nullable = false)
    public long getNumber() { return number; }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", targetEntity=Group.class)    //*группы* мапнуты полем course
    public Set<Group> getGroups() { return groups; }


    public void setNumber(long number) { this.number = number; }

    public void setId(long id) { this.id = id; }

    public void setGroups(Set<Group> groups) { this.groups = groups; }
}
