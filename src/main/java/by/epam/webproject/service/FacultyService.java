package by.epam.webproject.service;

import by.epam.webproject.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    FacultyDTO get(Long univerId, Long facultyId);

    List<FacultyDTO> getAll(Long univerId);

}
