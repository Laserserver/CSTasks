package vsu.kurs3.att1.task3.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    private int id;
    private int groupId;
    private String name;
    private String surname;
    private Marks marks;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "ID", cascade = CascadeType.ALL)
    public Marks getMarks() {
        return marks;
    }

    @Column(name = "Surname", nullable = false)
    public String getSurname() {
        return surname;
    }

    @Column(name = "Name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "GroupID")
    public int getGroupId() {
        return groupId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }
}
