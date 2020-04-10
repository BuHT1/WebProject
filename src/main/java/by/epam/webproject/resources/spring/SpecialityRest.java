package by.epam.webproject.resources.spring;

import by.epam.webproject.dto.SpecialityDTO;
import by.epam.webproject.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/universities/{univerId}/faculties/{facultyId}/specialities", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpecialityRest {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping
    public ResponseEntity<List<SpecialityDTO>> getAll(@PathVariable("univerId") final Long univerId,
                                                      @PathVariable("facultyId") final Long facultyId) {
        List<SpecialityDTO> specialityDTOS = specialityService.getAll(univerId, facultyId);

        return ResponseEntity.ok(specialityDTOS);
    }


    @GetMapping(path = "/{specialityId}")
    public ResponseEntity get(@PathVariable("univerId") final Long univerId,
                              @PathVariable("facultyId") final Long facultyId,
                              @PathVariable("specialityId") final Long specialityId) {
        SpecialityDTO speciality = specialityService.get(univerId, facultyId, specialityId);
        if (speciality == null) {
            return ResponseEntity.status(404).body("Speciality not found!");
        }
        return ResponseEntity.ok(speciality);
    }

}

