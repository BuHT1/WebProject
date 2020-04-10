package by.epam.webproject.resources.spring;

import by.epam.webproject.dto.StudentDTO;
import by.epam.webproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/universities/{univerId}/faculties/{facultyId}/specialities/{specialityId}/groups/{groupId}/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRest {

    @Autowired
    private StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@PathVariable("univerId") final Long univerId,
                               @PathVariable("facultyId") final Long facultyId,
                               @PathVariable("specialityId") final Long specialityId,
                               @PathVariable("groupId") final Long groupId,
                               @RequestBody StudentDTO studentDTO) {
        try {
            StudentDTO savedStudentDTO = studentService.save(univerId, facultyId, specialityId, groupId, studentDTO);
            if (savedStudentDTO == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.status(201).header("Location", ServletUriComponentsBuilder.fromCurrentRequest().toUriString() + "/" + savedStudentDTO.getId()).body(savedStudentDTO);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(@PathVariable("univerId") final Long univerId,
                                                   @PathVariable("facultyId") final Long facultyId,
                                                   @PathVariable("specialityId") final Long specialityId,
                                                   @PathVariable("groupId") final Long groupId) {
        List<StudentDTO> studentDTOS = studentService.getAll(univerId, facultyId, specialityId, groupId);

        return ResponseEntity.ok(studentDTOS);
    }


    @GetMapping(path = "/{studentId}")
    public ResponseEntity get(@PathVariable("univerId") final Long univerId,
                              @PathVariable("facultyId") final Long facultyId,
                              @PathVariable("specialityId") final Long specialityId,
                              @PathVariable("groupId") final Long groupId,
                              @PathVariable("studentId") final Long studentId) {
        StudentDTO student = studentService.get(univerId, facultyId, specialityId, groupId, studentId);
        if (student == null) {
            return ResponseEntity.status(404).body("Students not found!");
        }
        return ResponseEntity.ok(student);
    }


    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity delete(@PathVariable("univerId") final Long univerId,
                                 @PathVariable("facultyId") final Long facultyId,
                                 @PathVariable("specialityId") final Long specialityId,
                                 @PathVariable("groupId") final Long groupId,
                                 @PathVariable("studentId") final Long studentId) {
        try {
            studentService.delete(univerId, facultyId, specialityId, groupId, studentId);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Group not found.");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{studentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable("univerId") final Long univerId,
                                 @PathVariable("facultyId") final Long facultyId,
                                 @PathVariable("specialityId") final Long specialityId,
                                 @PathVariable("groupId") final Long groupId,
                                 @PathVariable("studentId") final Long studentId,
                                 @RequestBody StudentDTO studentDTO) {
        try {
            StudentDTO updatedStudent = studentService.update(univerId, facultyId, specialityId, groupId, studentId, studentDTO);
            if (updatedStudent == null) {
                return ResponseEntity.status(404).body("Student not found!");
            }
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

}

