package by.epam.webproject.persistence;

import java.util.List;

public interface PersistenceService<K,E> {

    E save(E entity);

    E get(K id);

    List<E> getAll();

    void delete(K id);

    E update(E entity);

}
