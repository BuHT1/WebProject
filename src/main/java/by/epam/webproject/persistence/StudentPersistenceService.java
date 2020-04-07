package by.epam.webproject.persistence;

import by.epam.webproject.entities.StudentEntity;

import java.util.List;

public interface StudentPersistenceService extends PersistenceService<Long ,StudentEntity> {

    List<StudentEntity> getStudentsByStudentIds(List<Long> studentIds);
}
