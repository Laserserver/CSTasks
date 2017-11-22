package vsu.kurs3.att1.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Course;
import vsu.kurs3.att1.task3.hibNormal.repositories.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) { this.repository = repository; }

    public Course add(Course course) { return repository.save(course); }

    public Course edit(Course course){
        Course oldCourse = get(course.getId());
        if(oldCourse != null){
            return repository.save(course);
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public Course get(long id) {
        Course course = repository.findOne(id);
        if (course !=null)
            return course;
        else
            return null;
    }

    public Iterable<Course> getAll() { return repository.findAllByOrderByNumberAsc(); }
}
