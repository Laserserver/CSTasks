package vsu.kurs3.att1.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.att1.task3.hibNormal.models.Marks;
import vsu.kurs3.att1.task3.hibNormal.repositories.MarksRepository;

@Service
public class MarksService {

    private final MarksRepository repository;

    public MarksService(MarksRepository repository) { this.repository = repository; }

    public Marks add(Marks marks) { return repository.save(marks); }

    public Marks edit(Marks marks){
        Marks oldMarks = get(marks.getId());
        if(oldMarks != null){
            return repository.save(marks);
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public Marks get(long id) {
        Marks marks = repository.findOne(id);
        if (marks !=null)
            return marks;
        else
            return null;
    }

    public Iterable<Marks> getAll() { return repository.findAll(); }
}
