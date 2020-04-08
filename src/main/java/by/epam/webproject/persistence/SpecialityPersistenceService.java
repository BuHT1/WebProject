package by.epam.webproject.persistence;

import by.epam.webproject.entities.SpecialityEntity;
import by.epam.webproject.entities.StudentEntity;

import java.util.List;

public interface SpecialityPersistenceService {

    List<SpecialityEntity> getAll(Long univerId, Long facultyId);

    SpecialityEntity get(Long univerId, Long facultyId, Long specialityId);

}
