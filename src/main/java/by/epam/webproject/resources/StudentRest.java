package by.epam.webproject.resources;

import by.epam.webproject.dto.GroupDTO;
import by.epam.webproject.dto.StudentDTO;
import by.epam.webproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(path = "/rest/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRest {

    @Autowired
    private StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.save(studentDTO));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentDTO> get(@PathVariable("id") final Long studentId) {
        return ResponseEntity.ok(studentService.get(studentId));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long studentId) {
        studentService.delete(studentId);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> update(@PathVariable("id") final Long studentId,
                                             @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.update(studentId, studentDTO));
    }

    @GetMapping(path = "/getStudentsByGroupId/{groupId}")
    public ResponseEntity<List<StudentDTO>> getGroupsByStudentId(@PathVariable("groupId") Long groupId) {

        return ResponseEntity.ok(studentService.getStudentsByGroupId(groupId));
    }
}

