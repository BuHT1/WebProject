package by.epam.webproject.service.impl;

import by.epam.webproject.dto.FacultyDTO;
import by.epam.webproject.dto.mappers.FacultyMapper;
import by.epam.webproject.persistence.FacultyPersistenceService;
import by.epam.webproject.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyPersistenceService facultyPersistenceService;

    @Autowired
    private FacultyMapper facultyMapper;

    @Override
    public FacultyDTO get(Long univerId, Long facultyId) {
        return facultyMapper.mapToModel(facultyPersistenceService.get(univerId, facultyId));
    }

    @Override
    public List<FacultyDTO> getAll(Long univerId) {
        return facultyPersistenceService.getAll(univerId).stream()
                .map(facultyMapper::mapToModel)
                .collect(Collectors.toList());
    }
}
