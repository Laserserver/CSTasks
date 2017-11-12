package vsu.kurs3.att1.task3.hibNormal.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CourseNum", nullable = false)
    private long number;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", targetEntity=Group.class)    //*группы* мапнуты полем course
    private Set<Group> groups;

    public Course(){}

    public Course(long Num, Set<Group> groups){
        this.number = Num;
        this.groups = groups;
    }

    public long getId(){ return this.id;}

    public long getNumber() { return number; }

    public Set<Group> getGroups() { return groups; }


    public void setNumber(long number) { this.number = number; }

    public void setId(long id) { this.id = id; }

    public void setGroups(Set<Group> groups) { this.groups = groups; }
}
