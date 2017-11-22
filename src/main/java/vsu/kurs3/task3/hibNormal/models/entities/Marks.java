package vsu.kurs3.task3.hibNormal.models.entities;

import javax.persistence.*;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn                   //Означает, что этот первичный ключ является внешним
    private Student student;

    @Column(name = "mark_first", nullable = false)
    private Boolean markOne;

    @Column(name = "mark_second", nullable = false)
    private Boolean markTwo;

    @Column(name = "mark_third", nullable = false)
    private Boolean markThree;

    public Marks(){}


    public long getId() { return id; }

    public Student getStudent() { return student; }

    public Boolean getMarkOne() { return markOne; }

    public Boolean getMarkTwo() { return markTwo; }

    public Boolean getMarkThree() { return markThree; }


    public void setId(long id) { this.id = id; }

    public void setStudent(Student student) { this.student = student; }

    public void setMarkOne(Boolean markOne) { this.markOne = markOne; }

    public void setMarkTwo(Boolean markTwo) { this.markTwo = markTwo; }

    public void setMarkThree(Boolean markThree) { this.markThree = markThree; }
}
