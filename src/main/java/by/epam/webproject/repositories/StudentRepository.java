package by.epam.webproject.repositories;

import by.epam.webproject.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query(value = "SELECT * FROM students join groups on students.id_group = groups.id_group " +
            "join speciality on speciality.id_speciality=groups.id_speciality " +
            "join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_faculty " +
            "where university.id_university=:univerId and faculty.id_faculty=:facultyId and " +
            "speciality.id_speciality=:specialityId and groups.id_group=:groupId", nativeQuery = true)
    List<StudentEntity> findAll(@Param("univerId") Long univerId,
                                @Param("facultyId") Long facultyId,
                                @Param("specialityId") Long specialityId,
                                @Param("groupId") Long groupId);

}
