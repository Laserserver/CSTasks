package vsu.kurs3.task3.hibNormal.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="groupid")
    private Group group;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "mark_first", nullable = false)
    private Boolean markOne;

    @Column(name = "mark_second", nullable = false)
    private Boolean markTwo;

    @Column(name = "mark_third", nullable = false)
    private Boolean markThree;


    public Student() {}


    public long getId() { return id; }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public Group getGroup() { return group; }

    public Boolean getMarkOne() { return markOne; }

    public Boolean getMarkTwo() { return markTwo; }

    public Boolean getMarkThree() { return markThree; }


    public void setId(long id) { this.id = id; }

    public void setGroup(Group group_id) { this.group = group_id; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setMarkOne(Boolean markOne) { this.markOne = markOne; }

    public void setMarkTwo(Boolean markTwo) { this.markTwo = markTwo; }

    public void setMarkThree(Boolean markThree) { this.markThree = markThree; }
}
