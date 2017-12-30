package vsu.kurs3.task3.hibNormal.models.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsu.kurs3.task3.hibNormal.models.converters.StudentConverter;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Student;
import vsu.kurs3.task3.hibNormal.models.repositories.StudentRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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

    public StudentDTO getStudentByGroupIdNameSurname(long groupId, String fullname){
        String[] arr = fullname.split("\\s+");
        Student st = repository.findByGroup_IdAndNameAndSurname(groupId, arr[0], arr[1]);
        if(st == null)
            return null;
        return StudentConverter.convertToDTO(st);
    }

    public List<String> getMarksByName(long groupId, String fullname){
        StudentDTO std = getStudentByGroupIdNameSurname(groupId, fullname);
        LinkedList<String> str = new LinkedList<>();
        str.add("1 этап: " + (std.getMarkOne() ? "сдано" : "не сдано"));
        str.add("2 этап: " + (std.getMarkTwo() ? "сдано" : "не сдано"));
        str.add("3 этап: " + (std.getMarkThree() ? "сдано" : "не сдано"));

        return str;
    }

    public void changeStage(StudentDTO std, String stage){
        String temp = stage.replaceAll("[\\D]", "");
        if(temp.equals(""))
            return;
        int num = Integer.parseInt(temp);
        std.changeStage(num);
        edit(std);
    }

    public List<String> getStudents(GroupDTO group){
        List<String> lst = new LinkedList<>();

        Iterable<StudentDTO> studs =
                getAllStudentsFromGroup(group.getId());
        if(studs != null){
            for(StudentDTO st: studs)
                lst.add(st.getName() + " " + st.getSurname());
        }

        return lst;
    }
}
