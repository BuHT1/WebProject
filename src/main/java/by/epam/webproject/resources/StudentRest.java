package by.epam.webproject.resources;

import by.epam.webproject.dto.StudentDTO;
import by.epam.webproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/universities/{univerId}/faculties/{facultyId}/specialities/{specialityId}/groups/{groupId}/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRest {

    @Autowired
    private StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> save(@PathVariable("univerId") final Long univerId,
                                           @PathVariable("facultyId") final Long facultyId,
                                           @PathVariable("specialityId") final Long specialityId,
                                           @PathVariable("groupId") final Long groupId,
                                           @RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudentDTO = studentService.save(univerId, facultyId, specialityId, groupId, studentDTO);
        if (savedStudentDTO == null) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).body(savedStudentDTO);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(@PathVariable("univerId") final Long univerId,
                                                   @PathVariable("facultyId") final Long facultyId,
                                                   @PathVariable("specialityId") final Long specialityId,
                                                   @PathVariable("groupId") final Long groupId) {
        List<StudentDTO> studentDTOS = studentService.getAll(univerId, facultyId, specialityId, groupId);
        if (CollectionUtils.isEmpty(studentDTOS)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentDTOS);
    }


    @GetMapping(path = "/{studentId}")
    public ResponseEntity<StudentDTO> get(@PathVariable("univerId") final Long univerId,
                                          @PathVariable("facultyId") final Long facultyId,
                                          @PathVariable("specialityId") final Long specialityId,
                                          @PathVariable("groupId") final Long groupId,
                                          @PathVariable("studentId") final Long studentId) {
        StudentDTO student = studentService.get(univerId, facultyId, specialityId, groupId, studentId);
        if (student == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(student);
    }


    @DeleteMapping(path = "/{studentId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("univerId") final Long univerId,
                       @PathVariable("facultyId") final Long facultyId,
                       @PathVariable("specialityId") final Long specialityId,
                       @PathVariable("groupId") final Long groupId,
                       @PathVariable("studentId") final Long studentId) {
        studentService.delete(univerId, facultyId, specialityId, groupId, studentId);
    }

    @PutMapping(path = "/{studentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> update(@PathVariable("univerId") final Long univerId,
                                             @PathVariable("facultyId") final Long facultyId,
                                             @PathVariable("specialityId") final Long specialityId,
                                             @PathVariable("groupId") final Long groupId,
                                             @PathVariable("studentId") final Long studentId,
                                             @RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudent = studentService.update(univerId, facultyId, specialityId, groupId, studentId, studentDTO);
        if (updatedStudent == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

}

