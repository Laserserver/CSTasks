package vsu.kurs3.att1.task3.hibNormal.models;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    private long id;

    private long groupId;

    private String name;

    private String surname;

    private Marks marks;

    public Student() {}

    public Student(String name, String surname, Marks marks){
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() { return id; }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)  //Ссылка на поле student типа Student
    public Marks getMarks() { return marks; }

    @Column(name = "Surname", nullable = false)
    public String getSurname() { return surname; }

    @Column(name = "Name", nullable = false)
    public String getName() { return name; }

    @Column(name = "GroupID")
    public long getGroupId() { return groupId; }


    public void setId(long id) { this.id = id; }

    public void setGroupId(long groupId) { this.groupId = groupId; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setMarks(Marks marks) { this.marks = marks; }
}
