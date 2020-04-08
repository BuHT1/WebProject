package by.epam.webproject.persistence;

import by.epam.webproject.entities.FacultyEntity;

import java.util.List;

public interface FacultyPersistenceService {

    List<FacultyEntity> getAll(Long univerId);

    FacultyEntity get(Long univerId, Long facultyId);

}
