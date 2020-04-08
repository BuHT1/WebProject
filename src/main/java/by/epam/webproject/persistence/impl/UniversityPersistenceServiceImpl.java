package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.UniversityEntity;
import by.epam.webproject.persistence.UniversityPersistenceService;
import by.epam.webproject.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityPersistenceServiceImpl implements UniversityPersistenceService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<UniversityEntity> getAll() {
        return universityRepository.findAll();
    }

    @Override
    public UniversityEntity get(Long univerId) {
        return universityRepository.findById(univerId).orElse(null);
    }
}
