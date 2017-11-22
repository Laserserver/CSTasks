package vsu.kurs3.task3.hibNormal.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="groupnum")
    private Group group;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)  //Ссылка на поле student типа Student
    private Marks marks;

    public Student() {}


    public long getId() { return id; }

    public Marks getMarks() { return marks; }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public Group getGroup() { return group; }


    public void setId(long id) { this.id = id; }

    public void setGroup(Group group_id) { this.group = group_id; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setMarks(Marks marks) { this.marks = marks; }
}
