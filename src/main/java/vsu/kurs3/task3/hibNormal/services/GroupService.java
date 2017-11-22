package vsu.kurs3.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.task3.hibNormal.models.converters.GroupConverter;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Group;
import vsu.kurs3.task3.hibNormal.repositories.GroupRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class GroupService {

    private final GroupRepository repository;

    public GroupService(GroupRepository repository) { this.repository = repository; }

    public GroupDTO add(GroupDTO group) {
       return GroupConverter.convertToDTO(repository.save(GroupConverter.convertToEntity(group)));
    }

    public GroupDTO edit(GroupDTO group){
        GroupDTO oldGroup = get(group.getId());
        if(oldGroup != null){
           return GroupConverter.convertToDTO(repository.save(GroupConverter.convertToEntity(group)));
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public GroupDTO get(long id) {
        GroupDTO group = GroupConverter.convertToDTO(repository.findOne(id));
        if (group != null)
            return group;
        else
            return null;
    }

    public Iterable<GroupDTO> getAll() {
        Iterable<Group> groups = repository.findAllByOrderByNumberAsc();
        Set<GroupDTO> grs = new HashSet<>();
        for (Group gr: groups) {
            grs.add(GroupConverter.convertToDTO(gr));
        }
        return grs;
    }
}
