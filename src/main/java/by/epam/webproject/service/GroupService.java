package by.epam.webproject.service;

import by.epam.webproject.dto.GroupDTO;

import java.util.List;

public interface GroupService {

    GroupDTO save(Long univerId, Long facultyId, Long specialityId, GroupDTO groupDTO);

    GroupDTO get(Long univerId, Long facultyId, Long specialityId, Long groupId);

    List<GroupDTO> getAll(Long univerId, Long facultyId, Long specialityId);

    void delete(Long univerId, Long facultyId, Long specialityId, Long groupId);

    GroupDTO update(Long univerId, Long facultyId, Long specialityId, Long groupId, GroupDTO groupDTO);

}
