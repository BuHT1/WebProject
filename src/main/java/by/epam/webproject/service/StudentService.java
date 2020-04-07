package by.epam.webproject.service;

import by.epam.webproject.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);

    StudentDTO get(Long id);

    List<StudentDTO> getAll();

    void delete(Long id);

    StudentDTO update(Long studentId, StudentDTO studentDTO);

    List<StudentDTO> getStudentsByGroupId(Long groupId);
}
