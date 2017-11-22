package vsu.kurs3.task3.hibNormal.models.dto;

public class StudentDTO {

    private long id;

    private GroupDTO group;

    private String name;

    private String surname;

    private MarksDTO marks;

    public StudentDTO() {}

    public long getId() { return id; }

    public MarksDTO getMarks() { return marks; }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public GroupDTO getGroup() { return group; }


    public void setId(long id) { this.id = id; }

    public void setGroup(GroupDTO group) { this.group = group; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setMarks(MarksDTO marks) { this.marks = marks; }
}
