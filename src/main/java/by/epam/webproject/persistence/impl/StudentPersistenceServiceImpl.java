package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.StudentEntity;
import by.epam.webproject.persistence.StudentPersistenceService;
import by.epam.webproject.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPersistenceServiceImpl implements StudentPersistenceService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAll(Long univerId, Long facultyId, Long specialityId, Long groupId) {
        return studentRepository.findAll(univerId, facultyId, specialityId, groupId);
    }
}
