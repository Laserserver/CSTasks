package vsu.kurs3.task3.hibNormal.models.dto;

import java.util.Set;

public class CourseDTO {

    private long id;

    private long number;

    private Set<GroupDTO> groups;

    public CourseDTO(){}

    public long getId(){ return this.id;}

    public long getNumber() { return number; }

    public Set<GroupDTO> getGroups() { return groups; }


    public void setNumber(long number) { this.number = number; }

    public void setId(long id) { this.id = id; }

    public void setGroups(Set<GroupDTO> groups) { this.groups = groups; }
}
