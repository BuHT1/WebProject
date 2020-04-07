package by.epam.webproject.dto.mappers;

import by.epam.webproject.dto.GroupDTO;
import by.epam.webproject.entities.GroupEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GroupMapper implements EntityDTOMapper<GroupEntity, GroupDTO> {
    @Override
    public GroupDTO mapToModel(GroupEntity entity) {
        if (Objects.nonNull(entity)) {
            return new GroupDTO.Builder()
                    .withId(entity.getId())
                    .withName(entity.getName())
                    .withSpecialityOtdelenieId(entity.getSpecialityOtdelenieId())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public GroupEntity mapToEntity(GroupDTO dto) {
        if (Objects.nonNull(dto)) {
            return new GroupEntity.Builder()
                    .withId(dto.getId())
                    .withName(dto.getName())
                    .withSpecialityOtdelenieId(dto.getSpecialityOtdelenieId())
                    .build();
        } else {
            return null;
        }
    }
}
