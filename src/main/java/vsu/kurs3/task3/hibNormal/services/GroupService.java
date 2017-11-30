package vsu.kurs3.task3.hibNormal.services;

import org.springframework.stereotype.Service;
import vsu.kurs3.task3.hibNormal.models.converters.CourseConverter;
import vsu.kurs3.task3.hibNormal.models.converters.GroupConverter;
import vsu.kurs3.task3.hibNormal.models.dto.CourseDTO;
import vsu.kurs3.task3.hibNormal.models.dto.GroupDTO;
import vsu.kurs3.task3.hibNormal.models.entities.Group;
import vsu.kurs3.task3.hibNormal.models.entities.Student;
import vsu.kurs3.task3.hibNormal.repositories.GroupRepository;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepository repository;
    private int count;

    public GroupService(GroupRepository repository) { this.repository = repository; }

    public GroupDTO add(GroupDTO group) {
        Group grp = GroupConverter.convertToEntity(group);
        List<Student> stds = grp.getStudents();
        if(stds != null)
            for(Student st : stds)
                st.setGroup(grp);
        return GroupConverter.convertToDTO(repository.save(grp));
    }

    public GroupDTO edit(long course, GroupDTO group){
        delete(course, group);
        add(group);
        return group;
    }

    public GroupDTO edit(GroupDTO group){
        GroupDTO oldGroup = get(group.getId());
        if(oldGroup != null){
           return GroupConverter.convertToDTO(repository.save(GroupConverter.convertToEntity(group)));
        }
        return null;
    }

    public void delete(long id) { repository.delete(id); }

    public void delete(long course, GroupDTO group){
        Group gr = repository.findByCourse_IdAndAndNumber(course, group.getNumber());
        delete(gr.getId());
    }

    public GroupDTO get(long id) {
        GroupDTO group = GroupConverter.convertToDTO(repository.findOne(id));
        if (group != null)
            return group;
        else
            return null;
    }

    public Iterable<GroupDTO> getAll() {
        count = 0;
        Iterable<Group> groups = repository.findAllByOrderByNumberAsc();
        List<GroupDTO> grs = new LinkedList<>();
        for (Group gr: groups) {
            grs.add(GroupConverter.convertToDTO(gr));
            count++;
        }
        grs.sort(Comparator.comparingLong(GroupDTO::getNumber));
        return grs;
    }

    public GroupDTO getFromCourseByNum(long courseId, long number){
        return GroupConverter.convertToDTO(repository.findByCourse_IdAndAndNumber(courseId, number));
    }

    public long getGroupId(long course, GroupDTO group){
        return repository.findByCourse_IdAndAndNumber(course, group.getNumber()).getId();
    }

    public Iterable<GroupDTO> getAllGroupsFromCourseById(long courseId){
        count = 0;
        Iterable<Group> groups = repository.findGroupsByCourse_IdOrderByNumber(courseId);
        List<GroupDTO> grs = new LinkedList<>();
        for (Group gr: groups) {
            grs.add(GroupConverter.convertToDTO(gr));
            count++;
        }
        grs.sort(Comparator.comparingLong(GroupDTO::getNumber));
        return grs;
    }

    public int getCount(){
        return count;
    }
}