package by.epam.webproject.dto.mappers;

public interface EntityDTOMapper<E,D> {

    D mapToModel(E entity);
    E mapToEntity(D dto);
}
