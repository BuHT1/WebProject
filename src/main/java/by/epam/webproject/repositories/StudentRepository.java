package by.epam.webproject.repositories;

import by.epam.webproject.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    List<StudentEntity> findByIdIn(List<Long> studentIds);

}
