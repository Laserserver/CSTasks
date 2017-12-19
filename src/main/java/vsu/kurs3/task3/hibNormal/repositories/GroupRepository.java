package vsu.kurs3.task3.hibNormal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vsu.kurs3.task3.hibNormal.models.entities.Group;

@Repository
public interface GroupRepository  extends CrudRepository<Group, Long> {

    @Transactional
    Iterable<Group> findAllByOrderByNumberAsc();
    @Transactional
    Iterable<Group> findGroupsByCourse_IdOrderByNumber(long course);
    @Transactional
    Group findByCourse_IdAndNumber(long course, long number);

    @Override
    @Transactional
    Group save(Group gr);

    @Override
    @Transactional
    void delete(Long id);

    @Override
    @Transactional
    Iterable<Group> findAll();
}
