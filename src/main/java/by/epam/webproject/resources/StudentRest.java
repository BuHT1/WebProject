package by.epam.webproject.resources;

import by.epam.webproject.dto.StudentDTO;
import by.epam.webproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/universities/{univerId}/faculties/{facultyId}/specialities/{specialityId}/groups/{groupId}/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRest {

    @Autowired
    private StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> save(@PathVariable("univerId") Long univerId,
                                           @PathVariable("facultyId") Long facultyId,
                                           @PathVariable("specialityId") Long specialityId,
                                           @PathVariable("groupId") Long groupId,
                                           @RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudentDTO = studentService.save(univerId, facultyId, specialityId, groupId, studentDTO);

        return ResponseEntity.ok(savedStudentDTO);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(@PathVariable("univerId") Long univerId,
                                                   @PathVariable("facultyId") Long facultyId,
                                                   @PathVariable("specialityId") Long specialityId,
                                                   @PathVariable("groupId") Long groupId) {
        List<StudentDTO> studentDTOS = studentService.getAll(univerId, facultyId, specialityId, groupId);
        return ResponseEntity.ok(studentDTOS);
    }

//
//    @GetMapping(path = "/{id}")
//    public ResponseEntity<StudentDTO> get(@PathVariable("id") final Long studentId) {
//        return ResponseEntity.ok(studentService.get(studentId));
//    }
//
//
//    @DeleteMapping(path = "/{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable("id") final Long studentId) {
//        studentService.delete(studentId);
//    }
//
//    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<StudentDTO> update(@PathVariable("id") final Long studentId,
//                                             @RequestBody StudentDTO studentDTO) {
//        return ResponseEntity.ok(studentService.update(studentId, studentDTO));
//    }

}

