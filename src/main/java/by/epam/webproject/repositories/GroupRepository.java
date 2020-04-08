package by.epam.webproject.repositories;

import by.epam.webproject.entities.GroupEntity;
import by.epam.webproject.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

    @Query(value = "SELECT groups.* FROM groups join speciality on speciality.id_speciality=groups.id_speciality " +
            "join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_faculty " +
            "where university.id_university=:univerId and faculty.id_faculty=:facultyId " +
            "and speciality.id_speciality=:specialityId", nativeQuery = true)
    List<GroupEntity> findAll(@Param("univerId") Long univerId,
                              @Param("facultyId") Long facultyId,
                              @Param("specialityId") Long specialityId);

    @Query(value = "SELECT groups.* FROM groups join speciality on speciality.id_speciality=groups.id_speciality " +
            "join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_faculty " +
            "where university.id_university=:univerId and faculty.id_faculty=:facultyId " +
            "and speciality.id_speciality=:specialityId and groups.id_group=:groupId", nativeQuery = true)
    GroupEntity findOne(@Param("univerId") Long univerId,
                        @Param("facultyId") Long facultyId,
                        @Param("specialityId") Long specialityId,
                        @Param("groupId") Long groupId);

    @Query(value = "INSERT INTO groups(name, id_speciality) VALUES( :name," +
            "(select id_speciality from speciality " +
            "join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_university " +
            "where speciality.id_speciality=:specialityId and" +
            " university.id_university=:univerId and faculty.id_faculty=:facultyId)) RETURNING *", nativeQuery = true)
    GroupEntity save(@Param("univerId") Long univerId,
                     @Param("facultyId") Long facultyId,
                     @Param("specialityId") Long specialityId,
                     @Param("name") String name);

    @Query(value = "delete from groups where id_groups=(select id_groups from groups " +
            "join speciality on groups.id_speciality = speciality.id_speciality " +
            "join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_university " +
            "where university.id_university=:univerId and faculty.id_faculty=:facultyId" +
            " and speciality.id_speciality=:specialityId" +
            " and groups.id_group=:groupId)", nativeQuery = true)
    @Modifying
    void delete(@Param("univerId") Long univerId,
                @Param("facultyId") Long facultyId,
                @Param("specialityId") Long specialityId,
                @Param("groupId") Long groupId);
}
