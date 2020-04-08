package by.epam.webproject.service.impl;

import by.epam.webproject.dto.SpecialityDTO;
import by.epam.webproject.dto.mappers.SpecialityMapper;
import by.epam.webproject.persistence.SpecialityPersistenceService;
import by.epam.webproject.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityPersistenceService specialityPersistenceService;

    @Autowired
    private SpecialityMapper specialityMapper;

    @Override
    public SpecialityDTO get(Long univerId, Long facultyId, Long specialityId) {
        return specialityMapper.mapToModel(specialityPersistenceService.get(univerId, facultyId, specialityId));
    }

    @Override
    public List<SpecialityDTO> getAll(Long univerId, Long facultyId) {
        return specialityPersistenceService.getAll(univerId, facultyId).stream()
                .map(specialityMapper::mapToModel)
                .collect(Collectors.toList());
    }
}
