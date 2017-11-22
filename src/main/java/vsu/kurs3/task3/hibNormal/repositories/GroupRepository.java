package vsu.kurs3.task3.hibNormal.repositories;

import org.springframework.data.repository.CrudRepository;
import vsu.kurs3.task3.hibNormal.models.entities.Group;

public interface GroupRepository  extends CrudRepository<Group, Long> {

    Iterable<Group> findAllByOrderByNumberAsc();
}
