package by.epam.webproject.service;

import by.epam.webproject.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO save(Long univerId,Long facultyId,Long specialityId, Long groupId, StudentDTO studentDTO);

    StudentDTO get(Long univerId,Long facultyId,Long specialityId, Long groupId, Long studentId);

    List<StudentDTO> getAll(Long univerId,Long facultyId,Long specialityId, Long groupId);

    void delete(Long univerId,Long facultyId,Long specialityId, Long groupId, Long studentId);

    StudentDTO update(Long univerId,Long facultyId,Long specialityId, Long groupId, Long studentId, StudentDTO studentDTO);
}
