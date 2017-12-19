package vsu.kurs3.task3.hibNormal.models.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.task3.hibNormal.models.converters.CourseConverter;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Course;
import vsu.kurs3.task3.hibNormal.models.entities.Group;
import vsu.kurs3.task3.hibNormal.models.repositories.CourseRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    @Transactional
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

    @Transactional
    public void delete(long id) {
        repository.delete(id);
    }

    public CourseDTO get(long id) {
        return CourseConverter.convertToDTO(repository.findOne(id));
    }

    public CourseDTO getByNum(long num){
        Course crs = repository.findCourseByCoursenumEquals(num);
        if(crs == null)
            return null;
        return CourseConverter.convertToDTO(crs);
    }

    public CourseDTO getByName(String name){
        long num = Long.parseLong(name.replaceAll("[\\D]", ""));
        return getByNum(num);
    }

    public long addNewCourse(){
        CourseDTO crs = new CourseDTO();
        long count = repository.selectCount();
        long num;
        List<Long> lst = repository.selectCoursenum();
        if(lst.size() == 1)
        {
            num = lst.get(0) + 1;
            crs.setNumber(num);
            add(crs);
            return num;
        }
        for (int i = 0; i < lst.size() - 1; i++){
            long prev = lst.get(i);
            long next = lst.get(i + 1);
            if(next - prev != 1){
                num = prev + 1;
                crs.setNumber(num);
                add(crs);
                return num;
            }
        }
        num = count + 1;
        crs.setNumber(num);
        add(crs);
        return num;
    }

    public Iterable<CourseDTO> getAll() {
        Iterable<Course> courses = repository.findAll();
        List<CourseDTO> lst = new LinkedList<>();
        for(Course crs: courses){
            lst.add(CourseConverter.convertToDTO(crs));
        }
        lst.sort(Comparator.comparingLong(CourseDTO::getNumber));
        return lst;
    }

    public long getId(CourseDTO course){
        return course.getId();
    }

    public long getCount(){
        return repository.selectCount();
    }

    public List<String> getCourses(){
        Iterable<CourseDTO> crss = getAll();
        List<String> courses = new LinkedList<>();
        for (CourseDTO ab: crss) {
            courses.add(ab.getNumber() + " курс.");
        }
        return courses;
    }

    public List<String> getGroupsNamesByName(String name){
        LinkedList<String> str = new LinkedList<>();
        CourseDTO course = getByName(name);
        if(course != null)
        {
            List<GroupDTO> groups = course.getGroups();
            for (GroupDTO grp : groups) {
                str.add((grp.getNumber() + " группа."));
            }
        }
        return str;
    }


}
