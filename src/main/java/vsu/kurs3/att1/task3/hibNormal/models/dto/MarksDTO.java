package vsu.kurs3.att1.task3.hibNormal.models.dto;

public class MarksDTO {

    private long id;

    private StudentDTO student;


    private Boolean markOne;

    private Boolean markTwo;

    private Boolean markThree;

    public MarksDTO(){}

    public MarksDTO(StudentDTO student, Boolean m1, Boolean m2, Boolean m3){
        this.student = student;
        this.markOne = m1;
        this.markTwo = m2;
        this.markThree = m3;
    }

    public long getId() { return id; }

    public StudentDTO getStudent() { return student; }

    public Boolean getMarkOne() { return markOne; }

    public Boolean getMarkTwo() { return markTwo; }

    public Boolean getMarkThree() { return markThree; }


    public void setId(long id) { this.id = id; }

    public void setStudent(StudentDTO student) { this.student = student; }

    public void setMarkOne(Boolean markOne) { this.markOne = markOne; }

    public void setMarkTwo(Boolean markTwo) { this.markTwo = markTwo; }

    public void setMarkThree(Boolean markThree) { this.markThree = markThree; }
}
