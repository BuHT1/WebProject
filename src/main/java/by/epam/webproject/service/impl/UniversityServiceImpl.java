package by.epam.webproject.service.impl;

import by.epam.webproject.dto.UniversityDTO;
import by.epam.webproject.dto.mappers.UniversityMapper;
import by.epam.webproject.persistence.UniversityPersistenceService;
import by.epam.webproject.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityPersistenceService universityPersistenceService;

    @Autowired
    private UniversityMapper universityMapper;

    @Override
    public UniversityDTO get(Long univerId) {
        return universityMapper.mapToModel(universityPersistenceService.get(univerId));
    }

    @Override
    public List<UniversityDTO> getAll() {
        return universityPersistenceService.getAll().stream()
                .map(universityMapper::mapToModel)
                .collect(Collectors.toList());
    }
}
