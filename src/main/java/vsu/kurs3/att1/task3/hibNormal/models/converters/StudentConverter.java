package vsu.kurs3.att1.task3.hibNormal.models.converters;

import vsu.kurs3.att1.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Student;

public class StudentConverter {
    public static StudentDTO convertToDTO(Student student){
        StudentDTO stDto = new StudentDTO();
        stDto.setName(student.getName());
        stDto.setSurname(student.getSurname());
        stDto.setMarks(MarksConverter.convertToDTO(student.getMarks(), stDto));
        return stDto;
    }

    public static Student convertToEntity(StudentDTO student){
        Student stud = new Student();
        stud.setMarks(MarksConverter.convertToEntity(student.getMarks(), stud));
        stud.setName(student.getName());
        stud.setSurname(student.getSurname());
        return stud;
    }
}
