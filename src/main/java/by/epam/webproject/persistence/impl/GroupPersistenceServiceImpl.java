package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.GroupEntity;
import by.epam.webproject.persistence.GroupPersistenceService;
import by.epam.webproject.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupPersistenceServiceImpl implements GroupPersistenceService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<GroupEntity> getAll(Long univerId, Long facultyId, Long specialityId) {
        return groupRepository.findAll(univerId, facultyId, specialityId);
    }

    @Override
    public GroupEntity get(Long univerId, Long facultyId, Long specialityId, Long groupId) {
        return groupRepository.findOne(univerId, facultyId, specialityId, groupId);
    }

    @Override
    public GroupEntity save(Long univerId, Long facultyId, Long specialityId, GroupEntity groupEntity) {
        return groupRepository.save(univerId, facultyId, specialityId, groupEntity.getName());
    }

    @Override
    public GroupEntity update(GroupEntity groupEntity) {
        return groupRepository.save(groupEntity);
    }

    @Override
    public void delete(Long univerId, Long facultyId, Long specialityId, Long groupId) {
        groupRepository.delete(univerId, facultyId, specialityId, groupId);
    }
}
