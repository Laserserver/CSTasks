package vsu.kurs3.att1.task3.hibNormal.models;

import javax.persistence.*;

@Entity
@Table(name = "MarksStudent")
public class Marks {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn                   //Означает, что этот первичный ключ является внешним
    private Student student;


    @Column(name = "MarkFirst", nullable = false)
    private Boolean markOne;

    @Column(name = "MarkSecond", nullable = false)
    private Boolean markTwo;

    @Column(name = "MarkThird", nullable = false)
    private Boolean markThree;

    public Marks(){}

    public Marks(Student student, Boolean m1, Boolean m2, Boolean m3){
        this.student = student;
        this.markOne = m1;
        this.markTwo = m2;
        this.markThree = m3;
    }


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
