package vsu.kurs3.att1.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.att1.task3.hibNormal.models.entities.Group;
import vsu.kurs3.att1.task3.hibNormal.repositories.GroupRepository;

@Service
public class GroupService {

    private final GroupRepository repository;

    public GroupService(GroupRepository repository) { this.repository = repository; }

    public Group add(Group group) { return repository.save(group); }

    public Group edit(Group group){
        Group oldGroup = get(group.getId());
        if(oldGroup != null){
            return repository.save(group);
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public Group get(long id) {
        Group group = repository.findOne(id);
        if (group !=null)
            return group;
        else
            return null;
    }

    public Iterable<Group> getAll() { return repository.findAllByOrderByNumberAsc(); }
}
