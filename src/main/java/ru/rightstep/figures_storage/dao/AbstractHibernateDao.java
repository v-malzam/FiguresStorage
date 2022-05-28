package ru.rightstep.figures_storage.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDao<T extends Serializable> {
    @Autowired
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    /*public final void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }*/

    // API
    public T findOne(final long id) {
        return getCurrentSession().get(clazz, id);
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public T create(final T entity) {
        //Preconditions.checkNotNull(entity);
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T update(final T entity) {
        //Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        //Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        //Preconditions.checkState(entity != null);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
