package vsu.kurs3.task3.hibNormal.models.converters;

import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Group;
import vsu.kurs3.task3.hibNormal.models.entities.Student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class GroupConverter {
    public static GroupDTO convertToDTO(Group group){
        GroupDTO grDto = new GroupDTO();
        if(group == null)
            return grDto;
        grDto.setId(group.getId());
        grDto.setNumber(group.getNumber());
        if(group.getStudents() == null)
            return grDto;
        Iterator iter = group.getStudents().iterator();
        List<StudentDTO> set = new LinkedList<>();
        while(iter.hasNext())
        {
            set.add(StudentConverter.convertToDTO((Student)iter.next()));
        }
        grDto.setStudents(set);
        return grDto;
    }

    public static Group convertToEntity(GroupDTO group){
        Group gr = new Group();
        if(group == null)
            return gr;
        gr.setNumber(group.getNumber());
        //gr.setCourse(CourseConverter.convertToEntity(group.getCourse()));
        if(group.getStudents().isEmpty())
            return gr;
        Iterator iter = group.getStudents().iterator();
        List<Student> set = new LinkedList<>();
        while(iter.hasNext())
        {
            set.add(StudentConverter.convertToEntity((StudentDTO)iter.next()));
        }
        gr.setStudents(set);
        gr.setId(group.getId());
        return gr;
    }
}
