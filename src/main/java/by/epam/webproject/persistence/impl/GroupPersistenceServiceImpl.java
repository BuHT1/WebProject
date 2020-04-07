package by.epam.webproject.persistence.impl;

import by.epam.webproject.entities.GroupEntity;
import by.epam.webproject.persistence.GroupPersistenceService;
import by.epam.webproject.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupPersistenceServiceImpl implements GroupPersistenceService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public GroupEntity save(GroupEntity entity) {
        return groupRepository.save(entity);
    }

    @Override
    public GroupEntity get(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<GroupEntity> getAll() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    @Transactional
    public GroupEntity update(GroupEntity entity) {
        return groupRepository.save(entity);
    }

    @Override
    public List<GroupEntity> getGroupByGroupIds(List<Long> groupIds) {
        return groupRepository.findByIdIn(groupIds);
    }
}
