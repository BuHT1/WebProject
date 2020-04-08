package by.epam.webproject.repositories;

import by.epam.webproject.entities.FacultyEntity;
import by.epam.webproject.entities.StudentEntity;
import by.epam.webproject.entities.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {

    @Query(value = "SELECT faculty.* FROM faculty where id_university=:univerId", nativeQuery = true)
    List<FacultyEntity> findAll(@Param("univerId") Long univerId);

    @Query(value = "SELECT faculty.* FROM faculty where id_university=:univerId and id_faculty=:facultyId", nativeQuery = true)
    FacultyEntity findOne(@Param("univerId") Long univerId,
                          @Param("facultyId") Long facultyId);
}
