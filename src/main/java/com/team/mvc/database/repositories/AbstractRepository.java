package com.team.mvc.database.repositories;

import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class AbstractRepository<Entity> {

    private Class persistentClass;

    public AbstractRepository(Class persistentClass) {
        this.persistentClass = persistentClass;
    }



    @Autowired
    private SessionFactory sessionFactory;

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Entity getById(long id) throws NotFoundException {
        return (Entity) getSession().get(persistentClass, id);
            }
    public Entity getById(Integer id) throws NotFoundException {
        return (Entity) getSession().get(persistentClass, id);
    }

    public List<Entity> getAll() {
        return getSession().createCriteria(persistentClass).list();
    }

    public void save(Entity entity) {
        getSession().persist(entity);

    }

    public void delete(Entity entity) {

        getSession().delete(entity);
    }


}
