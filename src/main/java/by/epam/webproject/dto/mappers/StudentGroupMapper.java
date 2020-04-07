package by.epam.webproject.dto.mappers;

import by.epam.webproject.dto.StudentGroupDTO;
import by.epam.webproject.entities.StudentGroupEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentGroupMapper implements EntityDTOMapper<StudentGroupEntity, StudentGroupDTO> {
    @Override
    public StudentGroupDTO mapToModel(StudentGroupEntity entity) {
        if (Objects.nonNull(entity)) {
            return new StudentGroupDTO.Builder()
                    .withId(entity.getId())
                    .withGroupId(entity.getGroupId())
                    .withStudentId(entity.getStudentId())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public StudentGroupEntity mapToEntity(StudentGroupDTO dto) {
        if (Objects.nonNull(dto)) {
            return new StudentGroupEntity.Builder()
                    .withId(dto.getId())
                    .withGroupId(dto.getGroupId())
                    .withStudentId(dto.getStudentId())
                    .build();
        } else {
            return null;
        }
    }
}
