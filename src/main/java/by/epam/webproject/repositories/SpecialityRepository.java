package by.epam.webproject.repositories;

import by.epam.webproject.entities.FacultyEntity;
import by.epam.webproject.entities.SpecialityEntity;
import by.epam.webproject.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<SpecialityEntity, Long> {

    @Query(value = "SELECT speciality.* FROM speciality join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_faculty where university.id_university=:univerId" +
            " and faculty.id_faculty=:facultyId", nativeQuery = true)
    List<SpecialityEntity> findAll(@Param("univerId") Long univerId,
                                @Param("facultyId") Long facultyId);

    @Query(value = "SELECT speciality.* FROM speciality join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_faculty where university.id_university=:univerId" +
            " and faculty.id_faculty=:facultyId and id_speciality=:specialityId", nativeQuery = true)
    SpecialityEntity findOne(@Param("univerId") Long univerId,
                          @Param("facultyId") Long facultyId,
                          @Param("specialityId") Long specialityId);
}
