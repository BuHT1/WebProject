package by.epam.webproject.service.impl;

import by.epam.webproject.dto.StudentDTO;
import by.epam.webproject.dto.mappers.EntityDTOMapper;
import by.epam.webproject.entities.StudentEntity;
import by.epam.webproject.persistence.StudentPersistenceService;
import by.epam.webproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentPersistenceService studentPersistenceService;

    @Autowired
    private EntityDTOMapper<StudentEntity, StudentDTO> studentMapper;

    @Override
    public StudentDTO save(Long univerId, Long facultyId, Long specialityId, Long groupId, StudentDTO studentDTO) {
        StudentEntity studentEntity = studentMapper.mapToEntity(studentDTO);
        return studentMapper.mapToModel(studentPersistenceService.save(univerId, facultyId, specialityId, groupId, studentEntity));
    }

    @Override
    public StudentDTO get(Long univerId, Long facultyId, Long specialityId, Long groupId, Long studentId) {
        return studentMapper.mapToModel(studentPersistenceService.get(univerId, facultyId, specialityId, groupId, studentId));
    }

    @Override
    public List<StudentDTO> getAll(Long univerId, Long facultyId, Long specialityId, Long groupId) {
        return studentPersistenceService.getAll(univerId, facultyId, specialityId, groupId).stream()
                .map(studentMapper::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long univerId, Long facultyId, Long specialityId, Long groupId, Long studentId) {
        studentPersistenceService.delete(univerId, facultyId, specialityId, groupId, studentId);
    }

    @Override
    public StudentDTO update(Long univerId, Long facultyId, Long specialityId, Long groupId, Long studentId, StudentDTO studentDTO) {
        StudentEntity savedEntity = studentPersistenceService.get(univerId, facultyId, specialityId, groupId, studentId);

        if (savedEntity == null) {
            return null;
        }

        StudentEntity entityToUpdate = studentMapper.mapToEntity(studentDTO);
        entityToUpdate.setId(savedEntity.getId());

        return studentMapper.mapToModel(studentPersistenceService.update(entityToUpdate));
    }
}
