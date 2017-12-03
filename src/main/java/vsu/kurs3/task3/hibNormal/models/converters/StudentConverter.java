package vsu.kurs3.task3.hibNormal.models.converters;

import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Student;

public class StudentConverter {
    public static StudentDTO convertToDTO(Student student){
        StudentDTO stDto = new StudentDTO();
        if(student == null)
            return stDto;
        stDto.setName(student.getName());
        stDto.setSurname(student.getSurname());
        stDto.setMarkOne(student.getMarkOne());
        stDto.setMarkTwo(student.getMarkTwo());
        stDto.setMarkThree(student.getMarkThree());
        stDto.setId(student.getId());
        return stDto;
    }

    public static Student convertToEntity(StudentDTO student){
        Student stud = new Student();
        if(student == null)
            return stud;
        stud.setMarkOne(student.getMarkOne());
        stud.setMarkTwo(student.getMarkTwo());
        stud.setMarkThree(student.getMarkThree());
        stud.setName(student.getName());
        stud.setSurname(student.getSurname());
        stud.setId(student.getId());
        return stud;
    }
}
