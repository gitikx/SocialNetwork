package com.senla.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class GenericDao<T, K> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public T getById(K id) {
        T object = (T) getCurrentSession().get(clazz, (Integer) id);
        return object;
    }

    public Boolean update(T entity) {
        getCurrentSession().update(entity);
        return null;
    }

    public List<T> getAll(){
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        query.from(clazz);
        return getCurrentSession().createQuery(query).getResultList();
    }

    public Boolean delete(K id) {
        getCurrentSession().delete(getById(id));
        return null;
    }

    public Integer create(T entity) {
        return (Integer) getCurrentSession().save(entity);

    }
}