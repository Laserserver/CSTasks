package vsu.kurs3.att1.task3.hibNormal.models;

import javax.persistence.*;

@Entity
@Table(name = "MarksStudent")
public class Marks {

    private long id;

    private Student student;


    private Boolean markOne;

    private Boolean markTwo;

    private Boolean markThree;

    public Marks(){}

    public Marks(Student student, Boolean m1, Boolean m2, Boolean m3){
        this.student = student;
        this.markOne = m1;
        this.markTwo = m2;
        this.markThree = m3;
    }


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() { return id; }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn                   //Означает, что этот первичный ключ является внешним
    public Student getStudent() { return student; }

    @Column(name = "MarkFirst", nullable = false)
    public Boolean getMarkOne() { return markOne; }

    @Column(name = "MarkSecond", nullable = false)
    public Boolean getMarkTwo() { return markTwo; }

    @Column(name = "MarkThird", nullable = false)
    public Boolean getMarkThree() { return markThree; }


    public void setId(long id) { this.id = id; }

    public void setStudent(Student student) { this.student = student; }

    public void setMarkOne(Boolean markOne) { this.markOne = markOne; }

    public void setMarkTwo(Boolean markTwo) { this.markTwo = markTwo; }

    public void setMarkThree(Boolean markThree) { this.markThree = markThree; }
}
