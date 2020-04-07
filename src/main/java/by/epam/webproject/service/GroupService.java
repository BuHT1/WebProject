package by.epam.webproject.service;

import by.epam.webproject.dto.GroupDTO;
import by.epam.webproject.dto.StudentGroupDTO;

import java.util.List;

public interface GroupService {

    GroupDTO save(GroupDTO groupDTO);

    GroupDTO get(Long id);

    List<GroupDTO> getAll();

    void delete(Long id);

    GroupDTO update(Long groupId, GroupDTO groupDTO);

    void addStudentToGroup(StudentGroupDTO studentGroupDTO);

    void deleteStudentFromGroup(StudentGroupDTO studentGroupDTO);

    List<GroupDTO> getGroupsByStudentId(Long studentId);
}
