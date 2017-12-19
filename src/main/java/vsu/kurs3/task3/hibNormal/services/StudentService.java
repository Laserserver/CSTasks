package vsu.kurs3.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.kurs3.task3.hibNormal.models.converters.GroupConverter;
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
            Student st = StudentConverter.convertToEntity(student);
            st.setGroup(repository.findOne(oldStudent.getId()).getGroup());
            return StudentConverter.convertToDTO(repository.save(st));
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public void delete(StudentDTO stud){
        delete(stud.getId());
    }

    public StudentDTO get(long id) {
        StudentDTO student = StudentConverter.convertToDTO(repository.findOne(id));
        if (student != null)
            return student;
        else
            return null;
    }
    @Transactional
    public Iterable<StudentDTO> getAll() {
        Iterable<Student> studs =  repository.findAll();
        Set<StudentDTO> students = new HashSet<>();
        for (Student st: studs){
            students.add(StudentConverter.convertToDTO(st));
        }
        return students;
    }
    public Iterable<StudentDTO> getAllStudentsFromGroup(long id) {
        Iterable<Student> studs =  repository.findAllByGroup_IdOrderByName(id);
        Set<StudentDTO> students = new HashSet<>();
        for (Student st: studs){
            students.add(StudentConverter.convertToDTO(st));
        }
        return students;
    }

    public StudentDTO getStudentByGroupIdNameSurname(long groupId, String name, String surname){
        Student st = repository.findByGroup_IdAndNameAndSurname(groupId, name, surname);
        if(st == null)
            return null;
        return StudentConverter.convertToDTO(st);
    }
}
