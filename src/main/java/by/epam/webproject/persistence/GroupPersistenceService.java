package by.epam.webproject.persistence;

import by.epam.webproject.entities.GroupEntity;
import by.epam.webproject.entities.StudentEntity;

import java.util.List;

public interface GroupPersistenceService {

    List<GroupEntity> getAll(Long univerId, Long facultyId, Long specialityId);

    GroupEntity get(Long univerId, Long facultyId, Long specialityId, Long groupId);

    GroupEntity save(Long univerId, Long facultyId, Long specialityId, GroupEntity groupEntity);

    GroupEntity update(GroupEntity groupEntity);

    void delete(Long univerId, Long facultyId, Long specialityId, Long groupId);

}
