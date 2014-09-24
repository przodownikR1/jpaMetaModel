package pl.java.scalatech.old;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

public interface GenericDao<T extends EntityCommon, I extends Serializable> {

    Integer DEFAULT_PAGE_SIZE = 25;

    void flush();

    void clear();

    long count();

    T get(I id);

    List<T> getAll();

    T persist(T t);

    T detach(T t);

    T update(T t);

    void remove(T t);

    T refresh(T t);

    List<T> findInRange(int firstResult, int maxResults);

    void lock(T t, LockModeType lockMode);

    List<T> find(String fieldName, Object fieldValue);

}
