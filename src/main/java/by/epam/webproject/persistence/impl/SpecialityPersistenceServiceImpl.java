package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.SpecialityEntity;
import by.epam.webproject.persistence.SpecialityPersistenceService;
import by.epam.webproject.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityPersistenceServiceImpl implements SpecialityPersistenceService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public List<SpecialityEntity> getAll(Long univerId, Long facultyId) {
        return specialityRepository.findAll(univerId, facultyId);
    }

    @Override
    public SpecialityEntity get(Long univerId, Long facultyId, Long specialityId) {
        return specialityRepository.findOne(univerId, facultyId, specialityId);
    }
}
