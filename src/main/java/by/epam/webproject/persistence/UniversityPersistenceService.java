package by.epam.webproject.persistence;

import by.epam.webproject.entities.UniversityEntity;

import java.util.List;

public interface UniversityPersistenceService {

    List<UniversityEntity> getAll();

    UniversityEntity get(Long univerId);
}
