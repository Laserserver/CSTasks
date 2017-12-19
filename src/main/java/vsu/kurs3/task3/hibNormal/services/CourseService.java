package vsu.kurs3.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.task3.hibNormal.models.converters.CourseConverter;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Course;
import vsu.kurs3.task3.hibNormal.models.entities.Group;
import vsu.kurs3.task3.hibNormal.repositories.CourseRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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

    @Transactional
    public CourseDTO edit(CourseDTO course){
        CourseDTO oldCourse = get(course.getId());
        if(oldCourse != null){
            Course crs = CourseConverter.convertToEntity(course);
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

    @Transactional
    public CourseDTO getByNum(long num){
        Course crs = repository.findCourseByCoursenumEquals(num);
        return CourseConverter.convertToDTO(crs);
    }

    @Transactional
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

    public long getFreeCoursePosition(){
        List<Long> lst = repository.selectCoursenum();
        if(lst.size() == 1)
            return lst.get(0) + 1;
        for (int i = 0; i < lst.size() - 1; i++){
            long prev = lst.get(i);
            long next = lst.get(i + 1);
            if(next - prev != 1){
                return prev + 1;
            }
        }
        return count + 1;
    }
}
