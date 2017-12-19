package vsu.kurs3.task3.hibNormal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vsu.kurs3.task3.hibNormal.models.entities.Course;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findCourseByCoursenumEquals(long num);

    @Override
    @Transactional
    Course save(Course crs);

    @Override
    @Transactional
    void delete(Long id);

    @Query("select c.coursenum from Course c order by c.coursenum")
    List<Long> selectCoursenum();
}
