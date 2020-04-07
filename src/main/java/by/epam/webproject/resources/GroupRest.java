package by.epam.webproject.resources;

import by.epam.webproject.dto.GroupDTO;
import by.epam.webproject.dto.StudentGroupDTO;
import by.epam.webproject.service.GroupService;
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
@RequestMapping(path = "/rest/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupRest {

    @Autowired
    private GroupService groupService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> save(@RequestBody GroupDTO groupDTO) {
        return ResponseEntity.ok(groupService.save(groupDTO));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GroupDTO> get(@PathVariable("id") final Long groupId) {
        return ResponseEntity.ok(groupService.get(groupId));
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAll() {
        return ResponseEntity.ok(groupService.getAll());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long groupId) {
        groupService.delete(groupId);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> update(@PathVariable("id") final Long groupId,
                                           @RequestBody GroupDTO groupDTO) {
        return ResponseEntity.ok(groupService.update(groupId, groupDTO));
    }

    @PostMapping(path = "/addStudentToGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addStudentToGroup(@RequestBody StudentGroupDTO studentGroupDTO) {

        groupService.addStudentToGroup(studentGroupDTO);
    }

    @PostMapping(path = "/deleteStudentFromGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStudentFromGroup(@RequestBody StudentGroupDTO studentGroupDTO) {

        groupService.deleteStudentFromGroup(studentGroupDTO);
    }

    @GetMapping(path = "/getGroupsByStudentId/{studentId}")
    public ResponseEntity<List<GroupDTO>> getGroupsByStudentId(@PathVariable("studentId") Long studentId) {

        return ResponseEntity.ok(groupService.getGroupsByStudentId(studentId));
    }
}
