package vsu.kurs3.att1.task3.hibNormal.models;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "GroupID")
    private long groupId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)  //Ссылка на поле student типа Student
    private Marks marks;

    public Student() {}

    public Student(String name, String surname, Marks marks){
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }

    public long getId() { return id; }

    public Marks getMarks() { return marks; }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public long getGroupId() { return groupId; }


    public void setId(long id) { this.id = id; }

    public void setGroupId(long groupId) { this.groupId = groupId; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setMarks(Marks marks) { this.marks = marks; }
}
