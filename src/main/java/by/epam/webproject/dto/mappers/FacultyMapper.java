package by.epam.webproject.dto.mappers;

import by.epam.webproject.dto.FacultyDTO;
import by.epam.webproject.entities.FacultyEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FacultyMapper implements EntityDTOMapper<FacultyEntity, FacultyDTO> {
    @Override
    public FacultyDTO mapToModel(FacultyEntity entity) {
        if (Objects.nonNull(entity)) {
            return new FacultyDTO.Builder()
                    .withId(entity.getId())
                    .withName(entity.getName())
                    .withUniversityId(entity.getUniversityId())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public FacultyEntity mapToEntity(FacultyDTO dto) {
        if (Objects.nonNull(dto)) {
            return new FacultyEntity.Builder()
                    .withId(dto.getId())
                    .withName(dto.getName())
                    .withUniversityId(dto.getUniversityId())
                    .build();
        } else {
            return null;
        }
    }
}
