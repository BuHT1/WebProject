package by.epam.webproject.dto.mappers;

import by.epam.webproject.dto.StudentDTO;
import by.epam.webproject.entities.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentMapper implements EntityDTOMapper<StudentEntity, StudentDTO> {
    @Override
    public StudentDTO mapToModel(StudentEntity entity) {
        if (Objects.nonNull(entity)) {
            return new StudentDTO.Builder()
                    .withId(entity.getId())
                    .withFirstName(entity.getFirstName())
                    .withLastName(entity.getLastName())
                    .withScore(entity.getScore())
                    .withGroupId(entity.getGroupId())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public StudentEntity mapToEntity(StudentDTO dto) {
        if (Objects.nonNull(dto))
            return new StudentEntity.Builder()
                    .withId(dto.getId())
                    .withFirstName(dto.getFirstName())
                    .withLastName(dto.getLastName())
                    .withScore(dto.getScore())
                    .withGroupId(dto.getGroupId())
                    .build();
        else {
            return null;
        }
    }
}
