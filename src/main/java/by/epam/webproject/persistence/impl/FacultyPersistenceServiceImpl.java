package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.FacultyEntity;
import by.epam.webproject.persistence.FacultyPersistenceService;
import by.epam.webproject.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyPersistenceServiceImpl implements FacultyPersistenceService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<FacultyEntity> getAll(Long univerId) {
        return facultyRepository.findAll(univerId);
    }

    @Override
    public FacultyEntity get(Long univerId, Long facultyId) {
        return facultyRepository.findOne(univerId, facultyId);
    }
}
