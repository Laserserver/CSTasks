package vsu.kurs3.task3.hibNormal.models.converters;

import vsu.kurs3.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Student;

public class StudentConverter {
    public static StudentDTO convertToDTO(Student student){
        StudentDTO stDto = new StudentDTO();
        stDto.setName(student.getName());
        stDto.setSurname(student.getSurname());
        stDto.setMarks(MarksConverter.convertToDTO(student.getMarks(), stDto));
        stDto.setGroup(GroupConverter.convertToDTO(student.getGroup()));
        return stDto;
    }

    public static Student convertToEntity(StudentDTO student){
        Student stud = new Student();
        stud.setMarks(MarksConverter.convertToEntity(student.getMarks(), stud));
        stud.setName(student.getName());
        stud.setSurname(student.getSurname());
        stud.setGroup(GroupConverter.convertToEntity(student.getGroup()));
        return stud;
    }
}
