package by.epam.webproject.resources;

import by.epam.webproject.dto.FacultyDTO;
import by.epam.webproject.dto.UniversityDTO;
import by.epam.webproject.service.FacultyService;
import by.epam.webproject.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/universities", produces = MediaType.APPLICATION_JSON_VALUE)
public class UniversityRest {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public ResponseEntity<List<UniversityDTO>> getAll() {
        List<UniversityDTO> universityDTOS = universityService.getAll();
        if (CollectionUtils.isEmpty(universityDTOS)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(universityDTOS);
    }


    @GetMapping(path = "/{univerId}")
    public ResponseEntity<UniversityDTO> get(@PathVariable("univerId") final Long univerId) {
        UniversityDTO universityDTO = universityService.get(univerId);
        if (universityDTO == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(universityDTO);
    }

}

