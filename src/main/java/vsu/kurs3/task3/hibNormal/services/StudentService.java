package vsu.kurs3.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.task3.hibNormal.models.converters.StudentConverter;
import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Student;
import vsu.kurs3.task3.hibNormal.repositories.StudentRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) { this.repository = repository; }

    public StudentDTO add(StudentDTO student) {
       return StudentConverter.convertToDTO(repository.save(StudentConverter.convertToEntity(student)));
    }

    public StudentDTO edit(StudentDTO student){
        StudentDTO oldStudent = get(student.getId());
        if(oldStudent != null){
           return StudentConverter.convertToDTO(repository.save(StudentConverter.convertToEntity(student)));
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public StudentDTO get(long id) {
        StudentDTO student = StudentConverter.convertToDTO(repository.findOne(id));
        if (student != null)
            return student;
        else
            return null;
    }

    public Iterable<StudentDTO> getAll() {
        Iterable<Student> studs =  repository.findAll();
        Set<StudentDTO> students = new HashSet<>();
        for (Student st: studs){
            students.add(StudentConverter.convertToDTO(st));
        }
        return students;
    }
}
