package vsu.kurs3.task3.hibNormal.repositories;

import org.springframework.data.repository.CrudRepository;
import vsu.kurs3.task3.hibNormal.models.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Iterable<Course> findAllByOrderByCoursenumAsc();
}
