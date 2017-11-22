package vsu.kurs3.att1.task3.hibNormal.models.converters;

import vsu.kurs3.att1.task3.hibNormal.models.dto.MarksDTO;
import vsu.kurs3.att1.task3.hibNormal.models.dto.StudentDTO;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Marks;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Student;

public class MarksConverter {
    public static MarksDTO convertToDTO(Marks marks, StudentDTO stud){
        MarksDTO mDto = new MarksDTO();
        mDto.setMarkOne(marks.getMarkOne());
        mDto.setMarkTwo(marks.getMarkTwo());
        mDto.setMarkThree(marks.getMarkThree());
        mDto.setStudent(stud);

        return mDto;
    }

    public static Marks convertToEntity(MarksDTO marks, Student stud){
        Marks mrk = new Marks();
        mrk.setMarkOne(marks.getMarkOne());
        mrk.setMarkTwo(marks.getMarkTwo());
        mrk.setMarkThree(marks.getMarkThree());
        mrk.setStudent(stud);

        return mrk;
    }
}
