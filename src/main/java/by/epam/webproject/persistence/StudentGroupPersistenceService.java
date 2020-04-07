package by.epam.webproject.persistence;

import by.epam.webproject.entities.StudentGroupEntity;

import java.util.List;

public interface StudentGroupPersistenceService extends PersistenceService<Long, StudentGroupEntity> {

    void deleteByStudentIdAndGroupId(Long studentId, Long groupId);

    List<StudentGroupEntity> getStudentGroupsByGroupId(Long groupIds);

    List<StudentGroupEntity> getStudentGroupsByStudentId(Long studentIds);

    void deleteByStudentId(Long studentId);

    void deleteByGroupId(Long groupId);

}
