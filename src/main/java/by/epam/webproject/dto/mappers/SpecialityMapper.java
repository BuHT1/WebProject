package by.epam.webproject.dto.mappers;

import by.epam.webproject.dto.SpecialityDTO;
import by.epam.webproject.entities.SpecialityEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SpecialityMapper implements EntityDTOMapper<SpecialityEntity, SpecialityDTO> {
    @Override
    public SpecialityDTO mapToModel(SpecialityEntity entity) {
        if (Objects.nonNull(entity)) {
            return new SpecialityDTO.Builder()
                    .withId(entity.getId())
                    .withName(entity.getName())
                    .withFacultyId(entity.getFacultyId())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public SpecialityEntity mapToEntity(SpecialityDTO dto) {
        if (Objects.nonNull(dto)) {
            return new SpecialityEntity.Builder()
                    .withId(dto.getId())
                    .withName(dto.getName())
                    .withFacultyId(dto.getFacultyId())
                    .build();
        } else {
            return null;
        }
    }
}
