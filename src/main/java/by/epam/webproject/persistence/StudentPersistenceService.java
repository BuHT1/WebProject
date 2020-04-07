package by.epam.webproject.persistence;

import by.epam.webproject.entities.StudentEntity;

import java.util.List;

public interface StudentPersistenceService {

    List<StudentEntity> getAll(Long univerId, Long facultyId, Long specialityId, Long groupId);
}
