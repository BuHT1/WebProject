package by.epam.webproject.service;

import by.epam.webproject.dto.SpecialityDTO;

import java.util.List;

public interface SpecialityService {

    SpecialityDTO get(Long univerId, Long facultyId, Long specialityId);

    List<SpecialityDTO> getAll(Long univerId, Long facultyId);
}
