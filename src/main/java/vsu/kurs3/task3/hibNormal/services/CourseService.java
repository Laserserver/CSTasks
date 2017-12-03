package vsu.kurs3.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.task3.hibNormal.models.converters.CourseConverter;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Course;
import vsu.kurs3.task3.hibNormal.models.entities.Group;
import vsu.kurs3.task3.hibNormal.repositories.CourseRepository;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

@Service
public class CourseService {

    private final CourseRepository repository;
    private int count;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseDTO add(CourseDTO course) {
        Course crs = CourseConverter.convertToEntity(course);
        List<Group> grps = crs.getGroups();
        if(grps != null)
            for(Group gr : grps)
                gr.setCourse(crs);
        return CourseConverter.convertToDTO(repository.save(crs));
    }

    public CourseDTO edit(CourseDTO course){
        CourseDTO oldCourse = get(course.getId());
        if(oldCourse != null){
            Course crs = CourseConverter.convertToEntity(oldCourse);
            List<Group> grps = crs.getGroups();
            if(grps != null)
                for(Group gr : grps)
                    gr.setCourse(crs);
            return CourseConverter.convertToDTO(repository.save(crs));
        }
        return null;
    }

    public void delete(long id) {
        repository.delete(id);
    }

    private void deleteByNum(long num){
        Course crs = repository.findCourseByCoursenumEquals(num);
        if(crs != null)
            repository.delete(crs);
    }

    public CourseDTO get(long id) {
        return CourseConverter.convertToDTO(repository.findOne(id));
    }

    public CourseDTO getByNum(long num){
        return CourseConverter.convertToDTO(
                repository.findCourseByCoursenumEquals(num));
    }

    public Iterable<CourseDTO> getAll() {
        count = 0;
        Iterable<Course> courses = repository.findAll();
        List<CourseDTO> lst = new LinkedList<>();
        for(Course crs: courses){
            lst.add(CourseConverter.convertToDTO(crs));
            count++;
        }
        lst.sort(Comparator.comparingLong(CourseDTO::getNumber));
        return lst;
    }

    public long getId(CourseDTO course){
        return course.getId();
    }

    public int getCount(){
        return count;
    }
}
