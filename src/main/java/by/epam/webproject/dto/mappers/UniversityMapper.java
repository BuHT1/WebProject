package by.epam.webproject.dto.mappers;

import by.epam.webproject.dto.UniversityDTO;
import by.epam.webproject.entities.UniversityEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UniversityMapper implements EntityDTOMapper<UniversityEntity, UniversityDTO> {
    @Override
    public UniversityDTO mapToModel(UniversityEntity entity) {
        if (Objects.nonNull(entity)) {
            return new UniversityDTO.Builder()
                    .withId(entity.getId())
                    .withName(entity.getName())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public UniversityEntity mapToEntity(UniversityDTO dto) {
        if (Objects.nonNull(dto)) {
            return new UniversityEntity.Builder()
                    .withId(dto.getId())
                    .withName(dto.getName())
                    .build();
        } else {
            return null;
        }
    }
}
