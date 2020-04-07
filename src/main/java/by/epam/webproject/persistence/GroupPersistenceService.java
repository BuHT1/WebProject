package by.epam.webproject.persistence;

import by.epam.webproject.entities.GroupEntity;

import java.util.List;

public interface GroupPersistenceService extends PersistenceService<Long, GroupEntity> {

    List<GroupEntity> getGroupByGroupIds(List<Long> groupIds);
}
