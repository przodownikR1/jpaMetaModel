package pl.java.scalatech.old.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.java.scalatech.old.EntityCommon;
import pl.java.scalatech.old.GenericDao;

public abstract class GenericDaoJPA<T extends EntityCommon, I extends Serializable> implements GenericDao<T, I> {

    @PersistenceContext(unitName = "unitPU")
    protected EntityManager entityManager;

    protected Class<T> domainClass = getDomainClass();

    public GenericDaoJPA() {
        domainClass = getDomainClass();
    }

    @Override
    public T get(I id) {
        return this.entityManager.find(domainClass, id);
    }

    @Override
    public List<T> getAll() {
        String queryStr = "select obj from " + this.domainClass.getName() + " obj";
        try {
            TypedQuery<T> query = this.entityManager.createQuery(queryStr, domainClass);
            return query.getResultList();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findInRange(int firstResult, int maxResults) {
        TypedQuery<T> query = entityManager.createQuery("Select t from " + domainClass.getSimpleName() + " t", domainClass);
        query.setFirstResult(firstResult).setMaxResults(maxResults);
        return query.getResultList();
    }

    @Override
    public T persist(T t) {
        this.entityManager.persist(t);
        return t;
    }

    @Override
    public T detach(T t) {
        this.entityManager.detach(t);
        return t;
    }

    @Override
    public T update(T t) {
        T result = this.entityManager.merge(t);

        return result;
    }

    @Override
    public void remove(T t) {

        T loaded = entityManager.find(domainClass, t.getId());
        if (loaded != null) {
            this.entityManager.remove(loaded);
        }
    }

    @Override
    public void flush() {
        this.entityManager.flush();
    }

    @Override
    public void clear() {
        this.entityManager.clear();
    }

    @Override
    public T refresh(final T transientObject) {

        T managedEntity = null;
        if (entityManager.contains(transientObject)) {
            managedEntity = transientObject;
        } else {
            managedEntity = entityManager.merge(transientObject);
        }
        entityManager.refresh(managedEntity);
        return managedEntity;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    @Override
    public long count() {
        return (Long) entityManager.createQuery("Select count(t) FROM " + domainClass.getSimpleName() + " t").getSingleResult();
    }

    @Override
    public List<T> find(String fieldName, Object fieldValue) {
        TypedQuery<T> query = this.entityManager.createQuery("SELECT t FROM " + this.domainClass.getName() + " t " + "WHERE t." + fieldName + " = :fieldValue",
                domainClass);
        query.setParameter("fieldValue", fieldValue);
        return query.getResultList();
    }

    @Override
    public void lock(T t, LockModeType lockMode) {
        entityManager.lock(t, lockMode);
    }
}