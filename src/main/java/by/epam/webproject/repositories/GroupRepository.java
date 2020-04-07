package by.epam.webproject.repositories;

import by.epam.webproject.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

    List<GroupEntity> findByIdIn(List<Long> groupId);

}
