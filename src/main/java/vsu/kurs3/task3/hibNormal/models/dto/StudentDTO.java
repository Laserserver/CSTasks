package vsu.kurs3.task3.hibNormal.models.dto;

public class StudentDTO {

    private long id;

    private GroupDTO group;

    private String name;

    private String surname;

    private Boolean markOne;

    private Boolean markTwo;

    private Boolean markThree;

    public StudentDTO() {}

    public long getId() { return id; }


    public String getSurname() { return surname; }

    public String getName() { return name; }

    public GroupDTO getGroup() { return group; }

    public Boolean getMarkOne() { return markOne; }

    public Boolean getMarkTwo() { return markTwo; }

    public Boolean getMarkThree() { return markThree; }


    public void setId(long id) { this.id = id; }

    public void setGroup(GroupDTO group) { this.group = group; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setMarkOne(Boolean markOne) { this.markOne = markOne; }

    public void setMarkTwo(Boolean markTwo) { this.markTwo = markTwo; }

    public void setMarkThree(Boolean markThree) { this.markThree = markThree; }
}
