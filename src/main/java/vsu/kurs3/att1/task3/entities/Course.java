package vsu.kurs3.att1.task3.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Course")
public class Course {

    private Integer id;
    private Integer number;
    private Set<Group> groups;

    public Course(){
    }

    public Course(int Num, Set<Group> groups){
        this.number = Num;
        this.groups = groups;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return this.id;
    }

    @Column(name = "CourseNum", nullable = false)
    public Integer getNumber() {
        return number;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "CourseID")    //*группы* мапнуты через CourseID
    public Set<Group> getGroups() {
        return groups;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
