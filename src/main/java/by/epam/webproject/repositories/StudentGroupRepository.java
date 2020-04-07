package by.epam.webproject.repositories;

import by.epam.webproject.entities.StudentGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface StudentGroupRepository extends JpaRepository<StudentGroupEntity, Long> {

    void deleteByStudentIdAndGroupId(Long studentId, Long groupId);

    List<StudentGroupEntity> findByStudentId(Long studentId);

    List<StudentGroupEntity> findByGroupId(Long groupId);

    void deleteByStudentId(Long studentId);

    void deleteByGroupId(Long groupId);
}
