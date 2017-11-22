package vsu.kurs3.task3.hibNormal.models.converters;

import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Course;
import vsu.kurs3.task3.hibNormal.models.entities.Group;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CourseConverter {
    public static CourseDTO convertToDTO(Course course){
        CourseDTO coDto = new CourseDTO();
        if(course == null)
            return coDto;
        coDto.setNumber(course.getCoursenum());
        Set<Group> dts = course.getGroups();
        if(dts == null)
            return coDto;
        Iterator iter = dts.iterator();
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
        if(course == null)
            return co;
        co.setCoursenum(course.getNumber());
        Set<GroupDTO> dts = course.getGroups();
        if(dts == null)
            return co;
        Iterator iter = dts.iterator();
        Set<Group> set = new LinkedHashSet<>();
        while(iter.hasNext())
        {
            set.add(GroupConverter.convertToEntity((GroupDTO)iter.next()));
        }
        co.setGroups(set);
        return co;
    }
}
