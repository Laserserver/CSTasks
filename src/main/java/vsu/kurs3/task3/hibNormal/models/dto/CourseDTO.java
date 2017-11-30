package vsu.kurs3.task3.hibNormal.models.dto;

import java.util.List;

public class CourseDTO {

    private long id;

    private long number;

    private List<GroupDTO> groups;

    public CourseDTO(){}

    public long getId(){ return this.id;}

    public long getNumber() { return number; }

    public List<GroupDTO> getGroups() { return groups; }


    public void setNumber(long number) { this.number = number; }

    public void setId(long id) { this.id = id; }

    public void setGroups(List<GroupDTO> groups) { this.groups = groups; }

    public void addGroup(GroupDTO group){
        groups.add(group);
    }

    public void deleteGroup(int num){
        for (int i = 0; i < groups.size(); i++) {
            if(groups.get(i).getNumber() == num)
            {
                groups.remove(groups.get(i));
                return;
            }
        }
    }
}