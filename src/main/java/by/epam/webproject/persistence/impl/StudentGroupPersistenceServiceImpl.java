package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.StudentGroupEntity;
import by.epam.webproject.persistence.StudentGroupPersistenceService;
import by.epam.webproject.repositories.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentGroupPersistenceServiceImpl implements StudentGroupPersistenceService {

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Override
    public StudentGroupEntity save(StudentGroupEntity entity) {
        return studentGroupRepository.save(entity);
    }

    @Override
    public StudentGroupEntity get(Long id) {
        return studentGroupRepository.findById(id).orElse(null);
    }

    @Override
    public List<StudentGroupEntity> getAll() {
        return studentGroupRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        studentGroupRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentGroupEntity update(StudentGroupEntity entity) {
        return studentGroupRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteByStudentIdAndGroupId(Long studentId, Long groupId) {
        studentGroupRepository.deleteByStudentIdAndGroupId(studentId, groupId);
    }

    @Override
    public List<StudentGroupEntity> getStudentGroupsByGroupId(Long groupId) {
        return studentGroupRepository.findByGroupId(groupId);
    }

    @Override
    public List<StudentGroupEntity> getStudentGroupsByStudentId(Long studentId) {
        return studentGroupRepository.findByStudentId(studentId);
    }

    @Transactional
    @Override
    public void deleteByStudentId(Long studentId) {
        studentGroupRepository.deleteByStudentId(studentId);
    }

    @Transactional
    @Override
    public void deleteByGroupId(Long groupId) {
        studentGroupRepository.findByGroupId(groupId);
    }
}
