package by.epam.webproject.persistence;

import by.epam.webproject.entities.StudentEntity;

import java.util.List;

public interface StudentPersistenceService {

    List<StudentEntity> getAll(Long univerId, Long facultyId, Long specialityId, Long groupId);

    StudentEntity get(Long univerId, Long facultyId, Long specialityId, Long groupId, Long studentId);

    StudentEntity save(Long univerId, Long facultyId, Long specialityId, Long groupId, StudentEntity studentEntity);

    StudentEntity update(StudentEntity studentEntity);

    void delete(Long univerId, Long facultyId, Long specialityId, Long groupId, Long studentId);

}
