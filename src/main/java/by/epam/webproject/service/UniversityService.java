package by.epam.webproject.service;

import by.epam.webproject.dto.UniversityDTO;

import java.util.List;

public interface UniversityService {

    UniversityDTO get(Long univerId);

    List<UniversityDTO> getAll();

}
