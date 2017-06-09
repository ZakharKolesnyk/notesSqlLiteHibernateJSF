package com.gmail.kolesnyk.zakhar;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.gmail.kolesnyk.zakhar.config.TransactionUtil.*;

/**
 * The {@code AbstractDao} implements main methods that required for ORM relations
 *
 * @author Kolesnyk Zakhar
 * @see com.gmail.kolesnyk.zakhar.BaseDao
 * @see com.gmail.kolesnyk.zakhar.user.UserDao
 * @see com.gmail.kolesnyk.zakhar.notes.NoteDao
 * @since JDK1.8
 */
public abstract class AbstractDao<T, I extends Serializable> implements BaseDao<T, I> {

    /**
     * class type of entity
     */
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T byId(I id) {
        return performTransaction(() -> (T) getSession().get(entityClass, id));
    }

    @Override
    public void save(T object) {
        performTransaction(() -> {
            getSession().save(object);
            return null;
        });
    }

    @Override
    public void update(T object) {
        performTransaction(() -> {
            getSession().update(object);
            return null;
        });
    }

    @Override
    public void remove(T object) {
        performTransaction(() -> {
            getSession().delete(object);
            return null;
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> list() {
        return performTransaction((Transaction<List<T>>) () -> getSession().createCriteria(entityClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
    }
}
