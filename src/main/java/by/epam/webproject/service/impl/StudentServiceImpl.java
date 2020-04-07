package by.epam.webproject.service.impl;

import by.epam.webproject.dto.StudentDTO;
import by.epam.webproject.dto.mappers.EntityDTOMapper;
import by.epam.webproject.entities.StudentEntity;
import by.epam.webproject.entities.StudentGroupEntity;
import by.epam.webproject.persistence.StudentGroupPersistenceService;
import by.epam.webproject.persistence.StudentPersistenceService;
import by.epam.webproject.exception.CustomRuntimeException;
import by.epam.webproject.exception.RuntimeExceptionCode;
import by.epam.webproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentPersistenceService studentPersistenceService;

    @Autowired
    private StudentGroupPersistenceService studentGroupPersistenceService;

    @Autowired
    private EntityDTOMapper<StudentEntity, StudentDTO> studentMapper;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {

        StudentEntity savedEntity = studentPersistenceService.save(studentMapper.mapToEntity(studentDTO));

        return studentMapper.mapToModel(savedEntity);
    }

    @Override
    public StudentDTO get(Long id) {
        StudentEntity entity = studentPersistenceService.get(id);

        if (Objects.isNull(entity)) {
            throw new CustomRuntimeException(RuntimeExceptionCode.STUDENT_NOT_FOUND, id.toString());
        }

        return studentMapper.mapToModel(studentPersistenceService.get(id));
    }

    @Override
    public List<StudentDTO> getAll() {
        return studentPersistenceService.getAll().stream()
                .map(studentMapper::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO update(Long studentId, StudentDTO studentDTO) {
        studentDTO.setId(studentId);
        StudentEntity entityToSave = studentMapper.mapToEntity(studentDTO);
        return studentMapper.mapToModel(studentPersistenceService.update(entityToSave));
    }

    @Override
    public List<StudentDTO> getStudentsByGroupId(Long groupId) {
        List<StudentGroupEntity> studentGroupEntities = studentGroupPersistenceService.getStudentGroupsByGroupId(groupId);

        List<Long> studentIds = studentGroupEntities.stream()
                .map(StudentGroupEntity::getStudentId)
                .collect(Collectors.toList());

        List<StudentEntity> studentEntities = studentPersistenceService.getStudentsByStudentIds(studentIds);

        return studentEntities.stream()
                .map(studentMapper::mapToModel)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        studentGroupPersistenceService.deleteByStudentId(id);
        studentPersistenceService.delete(id);
    }
}
