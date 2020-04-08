package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.StudentEntity;
import by.epam.webproject.persistence.StudentPersistenceService;
import by.epam.webproject.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentPersistenceServiceImpl implements StudentPersistenceService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAll(Long univerId, Long facultyId, Long specialityId, Long groupId) {
        return studentRepository.findAll(univerId, facultyId, specialityId, groupId);
    }

    @Override
    public StudentEntity get(Long univerId, Long facultyId, Long specialityId, Long groupId, Long studentId) {
        return studentRepository.findOne(univerId, facultyId, specialityId, groupId, studentId);
    }

    @Override
    public StudentEntity save(Long univerId, Long facultyId, Long specialityId, Long groupId, StudentEntity studentEntity) {
        return studentRepository.save(univerId, facultyId, specialityId, groupId,
                studentEntity.getFirstName(), studentEntity.getLastName(),
                studentEntity.getScore());
    }

    @Override
    @Transactional
    public StudentEntity update(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    @Transactional
    public void delete(Long univerId, Long facultyId, Long specialityId, Long groupId, Long studentId) {
        studentRepository.delete(univerId, facultyId, specialityId, groupId, studentId);
    }
}
