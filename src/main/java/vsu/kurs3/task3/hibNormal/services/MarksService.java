package vsu.kurs3.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import vsu.kurs3.task3.hibNormal.models.converters.MarksConverter;
import vsu.kurs3.task3.hibNormal.models.converters.StudentConverter;
import vsu.kurs3.task3.hibNormal.models.dto.MarksDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Marks;
import vsu.kurs3.task3.hibNormal.repositories.MarksRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class MarksService {

    private final MarksRepository repository;

    public MarksService(MarksRepository repository) { this.repository = repository; }

    public MarksDTO add(MarksDTO marks) {
       return MarksConverter.convertToDTO(repository.save(MarksConverter.convertToEntity(marks,
            StudentConverter.convertToEntity(marks.getStudent()))), marks.getStudent());
    }

    public MarksDTO edit(MarksDTO marks){
        MarksDTO oldMarks = get(marks.getId());
        if(oldMarks != null){
           return MarksConverter.convertToDTO(repository.save(MarksConverter.convertToEntity(marks,
                    StudentConverter.convertToEntity(marks.getStudent()))), marks.getStudent());
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public MarksDTO get(long id) {
        Marks mrk = repository.findOne(id);
        if(mrk == null)
            throw new NotImplementedException();
        MarksDTO marks = MarksConverter.convertToDTO(repository.findOne(id),
                StudentConverter.convertToDTO(mrk.getStudent()));
        if (marks != null)
            return marks;
        else
            return null;
    }

    public Iterable<MarksDTO> getAll() {
        Iterable<Marks> mrks = repository.findAll();
        Set<MarksDTO> marks = new HashSet<>();
        for (Marks mr: mrks){
            marks.add(MarksConverter.convertToDTO(mr,
                    StudentConverter.convertToDTO(mr.getStudent())));
        }
        return marks;
    }
}
