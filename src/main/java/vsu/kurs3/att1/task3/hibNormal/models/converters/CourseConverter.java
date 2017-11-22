package vsu.kurs3.att1.task3.hibNormal.models.converters;

import vsu.kurs3.att1.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.att1.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Course;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Group;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CourseConverter {
    public static CourseDTO convertToDTO(Course course){
        CourseDTO coDto = new CourseDTO();
        coDto.setNumber(course.getNumber());
        Iterator iter = course.getGroups().iterator();
        Set<GroupDTO> set = new LinkedHashSet<>();
        while(iter.hasNext())
        {
            set.add(GroupConverter.convertToDTO((Group)iter.next()));
        }
        coDto.setGroups(set);
        return coDto;
    }

    public static Course convertToEntity(CourseDTO course){
        Course co = new Course();
        co.setNumber(course.getNumber());
        Iterator iter = course.getGroups().iterator();
        Set<Group> set = new LinkedHashSet<>();
        while(iter.hasNext())
        {
            set.add(GroupConverter.convertToEntity((GroupDTO)iter.next()));
        }
        co.setGroups(set);
        return co;
    }
}
