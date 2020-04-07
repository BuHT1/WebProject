package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.StudentEntity;
import by.epam.webproject.persistence.StudentPersistenceService;
import by.epam.webproject.repositories.StudentRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentPersistenceServiceImpl implements StudentPersistenceService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentEntity save(StudentEntity entity) {
        return studentRepository.save(entity);
    }

    @Override
    public StudentEntity get(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentEntity update(StudentEntity entity) {
        return studentRepository.save(entity);
    }

    @Override
    public List<StudentEntity> getStudentsByStudentIds(List<Long> studentIds) {
        return studentRepository.findByIdIn(studentIds);
    }
}
