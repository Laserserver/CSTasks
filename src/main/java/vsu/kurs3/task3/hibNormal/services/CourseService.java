package vsu.kurs3.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.task3.hibNormal.models.converters.CourseConverter;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Course;
import vsu.kurs3.task3.hibNormal.repositories.CourseRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseDTO add(CourseDTO course) {
        return CourseConverter.convertToDTO(repository.save(CourseConverter.convertToEntity(course)));
    }

    public CourseDTO edit(CourseDTO course){
        CourseDTO oldCourse = get(course.getId());
        if(oldCourse != null){
            return CourseConverter.convertToDTO(repository.save(CourseConverter.convertToEntity(course)));
        }
        return null;
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public CourseDTO get(long id) {
        CourseDTO course = CourseConverter.convertToDTO(repository.findOne(id));
        if (course != null)
            return course;
        else
            return null;
    }

    public Iterable<CourseDTO> getAll() {
        Iterable<Course> subscribers= repository.findAll();
        List<CourseDTO> lst = new LinkedList<>();
        for(Course ab:subscribers){
            lst.add(CourseConverter.convertToDTO(ab));
        }
        return lst;
    }
}
