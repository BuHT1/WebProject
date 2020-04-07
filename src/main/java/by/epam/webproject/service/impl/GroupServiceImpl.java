package by.epam.webproject.service.impl;

import by.epam.webproject.dto.GroupDTO;
import by.epam.webproject.dto.StudentGroupDTO;
import by.epam.webproject.dto.mappers.EntityDTOMapper;
import by.epam.webproject.entities.GroupEntity;
import by.epam.webproject.entities.StudentGroupEntity;
import by.epam.webproject.exception.CustomRuntimeException;
import by.epam.webproject.exception.RuntimeExceptionCode;
import by.epam.webproject.persistence.GroupPersistenceService;
import by.epam.webproject.persistence.StudentGroupPersistenceService;
import by.epam.webproject.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupPersistenceService groupPersistenceService;

    @Autowired
    private StudentGroupPersistenceService studentGroupPersistenceService;

    @Autowired
    private EntityDTOMapper<GroupEntity, GroupDTO> groupMapper;

    @Autowired
    private EntityDTOMapper<StudentGroupEntity, StudentGroupDTO> studentGroupMapper;

    @Override
    public GroupDTO save(GroupDTO groupDTO) {
        GroupEntity entityToSave = groupMapper.mapToEntity(groupDTO);
        return groupMapper.mapToModel(groupPersistenceService.save(entityToSave));
    }

    @Override
    public GroupDTO get(Long id) {
        GroupEntity entity = groupPersistenceService.get(id);

        if (Objects.isNull(entity)) {
            throw new CustomRuntimeException(RuntimeExceptionCode.GROUP_NOT_FOUND, id.toString());
        }

        return groupMapper.mapToModel(entity);
    }

    @Override
    public List<GroupDTO> getAll() {
        return groupPersistenceService.getAll().stream()
                .map(groupMapper::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        studentGroupPersistenceService.deleteByGroupId(id);
        groupPersistenceService.delete(id);
    }

    @Override
    public GroupDTO update(Long studentId, GroupDTO groupDTO) {
        groupDTO.setId(studentId);

        GroupEntity entityToSave = groupMapper.mapToEntity(groupDTO);

        return groupMapper.mapToModel(groupPersistenceService.save(entityToSave));
    }

    @Override
    public void addStudentToGroup(StudentGroupDTO studentGroupDTO) {
        studentGroupPersistenceService.save(studentGroupMapper.mapToEntity(studentGroupDTO));
    }

    @Override
    public void deleteStudentFromGroup(StudentGroupDTO studentGroupDTO) {
        studentGroupPersistenceService.deleteByStudentIdAndGroupId(studentGroupDTO.getStudentId(), studentGroupDTO.getGroupId());
    }

    @Override
    public List<GroupDTO> getGroupsByStudentId(Long studentId) {

        List<StudentGroupEntity> studentGroupEntities = studentGroupPersistenceService.getStudentGroupsByStudentId(studentId);

        List<Long> groupIds = studentGroupEntities.stream()
                .map(StudentGroupEntity::getGroupId)
                .collect(Collectors.toList());

        List<GroupEntity> groupEntities = groupPersistenceService.getGroupByGroupIds(groupIds);

        return groupEntities.stream()
                .map(groupMapper::mapToModel)
                .collect(Collectors.toList());
    }

}
