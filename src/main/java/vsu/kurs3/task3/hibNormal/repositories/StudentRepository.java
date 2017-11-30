package vsu.kurs3.task3.hibNormal.repositories;

import org.springframework.data.repository.CrudRepository;
import vsu.kurs3.task3.hibNormal.models.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Iterable<Student> findAllByGroup_IdOrderByName(long id);

    Student findByGroup_IdAndNameAndSurname(long id, String name, String surname);
}
