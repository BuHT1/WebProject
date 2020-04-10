package by.epam.webproject.service.impl;

import by.epam.webproject.dto.GroupDTO;
import by.epam.webproject.dto.mappers.GroupMapper;
import by.epam.webproject.entities.GroupEntity;
import by.epam.webproject.persistence.GroupPersistenceService;
import by.epam.webproject.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupPersistenceService groupPersistenceService;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public GroupDTO save(Long univerId, Long facultyId, Long specialityId, GroupDTO groupDTO) {
        GroupEntity groupEntity = groupMapper.mapToEntity(groupDTO);

        return groupMapper.mapToModel(groupPersistenceService.save(univerId, facultyId, specialityId, groupEntity));
    }

    @Override
    public GroupDTO get(Long univerId, Long facultyId, Long specialityId, Long groupId) {
        return groupMapper.mapToModel(groupPersistenceService.get(univerId, facultyId, specialityId, groupId));
    }

    @Override
    public List<GroupDTO> getAll(Long univerId, Long facultyId, Long specialityId) {
        return groupPersistenceService.getAll(univerId, facultyId, specialityId).stream()
                .map(groupMapper::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long univerId, Long facultyId, Long specialityId, Long groupId) {
        if (Objects.isNull(groupPersistenceService.get(univerId, facultyId, specialityId, groupId))) {
            throw new RuntimeException("Student not found");
        }

        groupPersistenceService.delete(univerId, facultyId, specialityId, groupId);
    }

    @Override
    @Transactional
    public GroupDTO update(Long univerId, Long facultyId, Long specialityId, Long groupId, GroupDTO groupDTO) {
        GroupEntity groupEntity = groupPersistenceService.get(univerId, facultyId, specialityId, groupId);
        if (groupEntity == null) {
            return null;
        }

        GroupEntity groupEntityToUpdate = groupMapper.mapToEntity(groupDTO);
        groupEntityToUpdate.setId(groupEntity.getId());

        return groupMapper.mapToModel(groupPersistenceService.update(groupEntityToUpdate));
    }
}
