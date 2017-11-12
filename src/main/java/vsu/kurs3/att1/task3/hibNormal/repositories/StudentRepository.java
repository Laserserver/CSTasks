package vsu.kurs3.att1.task3.hibNormal.repositories;

import org.springframework.data.repository.CrudRepository;
import vsu.kurs3.att1.task3.hibNormal.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Iterable<Student> findAllByOrderByNameAsc();
}
