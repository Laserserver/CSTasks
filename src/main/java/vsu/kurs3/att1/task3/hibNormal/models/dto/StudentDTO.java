package vsu.kurs3.att1.task3.hibNormal.models.dto;

public class StudentDTO {

    private long id;

    private long groupId;

    private String name;

    private String surname;

    private MarksDTO marks;

    public StudentDTO() {}

    public StudentDTO(String name, String surname, MarksDTO marks){
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }

    public long getId() { return id; }

    public MarksDTO getMarks() { return marks; }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public long getGroupId() { return groupId; }


    public void setId(long id) { this.id = id; }

    public void setGroupId(long groupId) { this.groupId = groupId; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setMarks(MarksDTO marks) { this.marks = marks; }
}
