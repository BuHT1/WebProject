package by.epam.webproject.repositories;

import by.epam.webproject.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query(value = "SELECT * FROM students join groups on students.id_group = groups.id_group " +
            "join speciality on speciality.id_speciality=groups.id_speciality " +
            "join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_faculty " +
            "where university.id_university=:univerId and faculty.id_faculty=:facultyId and " +
            "speciality.id_speciality=:specialityId and groups.id_group=:groupId and id_students=:studentId", nativeQuery = true)
    StudentEntity findOne(@Param("univerId") Long univerId,
                          @Param("facultyId") Long facultyId,
                          @Param("specialityId") Long specialityId,
                          @Param("groupId") Long groupId,
                          @Param("studentId") Long studentId);


    @Query(value = "INSERT INTO students(first_name, last_name, average_score, id_group) VALUES( :firstName, :lastName, :averageScore," +
            "(select id_group from groups join speciality on groups.id_speciality = speciality.id_speciality " +
            "join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_university " +
            "where speciality.id_speciality=:specialityId and  id_group=:groupId and" +
            " university.id_university=:univerId and faculty.id_faculty=:facultyId)) RETURNING *", nativeQuery = true)
    StudentEntity save(@Param("univerId") Long univerId,
                       @Param("facultyId") Long facultyId,
                       @Param("specialityId") Long specialityId,
                       @Param("groupId") Long groupId,
                       @Param("firstName") String firstName,
                       @Param("lastName") String lastName,
                       @Param("averageScore") Double averageScore);


    @Query(value = "delete from students where id_students=(select id_students from students " +
            "join groups on groups.id_group=students.id_group " +
            "join speciality on groups.id_speciality = speciality.id_speciality " +
            "join faculty on faculty.id_faculty=speciality.id_faculty " +
            "join university on university.id_university=faculty.id_university " +
            "where university.id_university=:univerId and faculty.id_faculty=:facultyId" +
            " and speciality.id_speciality=:specialityId" +
            " and groups.id_group=:groupId and students.id_students=:studentId)", nativeQuery = true)
    @Modifying
    void delete(@Param("univerId") Long univerId,
                       @Param("facultyId") Long facultyId,
                       @Param("specialityId") Long specialityId,
                       @Param("groupId") Long groupId,
                       @Param("studentId") Long studentId);
}
