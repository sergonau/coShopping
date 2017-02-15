package com.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AbstractDAOImpl<T extends BaseEntity> implements AbstractDAO<T> {

    @PersistenceContext
    EntityManager entityManager;

    public AbstractDAOImpl() {

    }

    @Override
    public T save(T t) {
        if (t.getId() == null)
            entityManager.persist(t);
        else entityManager.merge(t);
        return t;
    }

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
