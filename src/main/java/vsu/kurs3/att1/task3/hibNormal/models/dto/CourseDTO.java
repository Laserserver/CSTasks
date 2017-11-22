package vsu.kurs3.att1.task3.hibNormal.models.dto;

import java.util.Set;

public class CourseDTO {

    private long id;

    private long number;

    private Set<GroupDTO> groups;

    public CourseDTO(){}

    public CourseDTO(long Num, Set<GroupDTO> groups){
        this.number = Num;
        this.groups = groups;
    }

    public long getId(){ return this.id;}

    public long getNumber() { return number; }

    public Set<GroupDTO> getGroups() { return groups; }


    public void setNumber(long number) { this.number = number; }

    public void setId(long id) { this.id = id; }

    public void setGroups(Set<GroupDTO> groups) { this.groups = groups; }
}
