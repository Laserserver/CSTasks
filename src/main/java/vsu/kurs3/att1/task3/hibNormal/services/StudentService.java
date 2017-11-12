package vsu.kurs3.att1.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.att1.task3.hibNormal.models.Student;
import vsu.kurs3.att1.task3.hibNormal.repositories.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) { this.repository = repository; }

    public Student add(Student student) { return repository.save(student); }

    public Student edit(Student student){
        Student oldStudent = get(student.getId());
        if(oldStudent != null){
            return repository.save(student);
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public Student get(long id) {
        Student student = repository.findOne(id);
        if (student !=null)
            return student;
        else
            return null;
    }

    public Iterable<Student> getAll() { return repository.findAll(); }
}
