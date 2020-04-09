package by.epam.webproject.resources;

import by.epam.webproject.dto.SpecialityDTO;
import by.epam.webproject.service.SpecialityService;
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
@RequestMapping(path = "/universities/{univerId}/faculties/{facultyId}/specialities", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpecialityRest {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping
    public ResponseEntity<List<SpecialityDTO>> getAll(@PathVariable("univerId") final Long univerId,
                                                      @PathVariable("facultyId") final Long facultyId) {
        List<SpecialityDTO> specialityDTOS = specialityService.getAll(univerId, facultyId);
        if (CollectionUtils.isEmpty(specialityDTOS)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(specialityDTOS);
    }


    @GetMapping(path = "/{specialityId}")
    public ResponseEntity<SpecialityDTO> get(@PathVariable("univerId") final Long univerId,
                                          @PathVariable("facultyId") final Long facultyId,
                                          @PathVariable("specialityId") final Long specialityId) {
        SpecialityDTO speciality = specialityService.get(univerId, facultyId, specialityId);
        if (speciality == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(speciality);
    }

}

