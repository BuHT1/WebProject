package by.epam.webproject.resources.spring;

import by.epam.webproject.dto.FacultyDTO;
import by.epam.webproject.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/universities/{univerId}/faculties", produces = MediaType.APPLICATION_JSON_VALUE)
public class FacultyRest {

    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public ResponseEntity<List<FacultyDTO>> getAll(@PathVariable("univerId") final Long univerId) {
        List<FacultyDTO> facultyDTOS = facultyService.getAll(univerId);

        return ResponseEntity.ok(facultyDTOS);
    }


    @GetMapping(path = "/{facultyId}")
    public ResponseEntity get(@PathVariable("univerId") final Long univerId,
                              @PathVariable("facultyId") final Long facultyId) {
        FacultyDTO facultyDTO = facultyService.get(univerId, facultyId);
        if (facultyDTO == null) {
            return ResponseEntity.status(404).body("Faculty not found!");
        }
        return ResponseEntity.ok(facultyDTO);
    }

}

