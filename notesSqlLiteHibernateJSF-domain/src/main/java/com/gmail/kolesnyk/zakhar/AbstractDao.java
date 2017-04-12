package com.gmail.kolesnyk.zakhar;

import com.gmail.kolesnyk.zakhar.config.TransactionUtil;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.gmail.kolesnyk.zakhar.config.TransactionUtil.performTransaction;
import static com.gmail.kolesnyk.zakhar.config.TransactionUtil.getSession;

/**
 * class implements main methods that required for ORM relations
 */
public abstract class AbstractDao<T, I extends Serializable> implements BaseDao<T, I> {

//    protected Session session;

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
//        return (T) getSession().get(entityClass, id);
    }

    @Override
    public void save(T object) {
        performTransaction((TransactionUtil.UpdateTransaction) () -> getSession().save(object));
    }

    @Override
    public void update(T object) {
        performTransaction(() -> getSession().update(object));
    }

    @Override
    public void remove(T object) {
        performTransaction(() -> getSession().delete(object));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> list() {
        return performTransaction((TransactionUtil.ReadTransaction<List<T>>) () -> getSession().createCriteria(entityClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
//        return getSession().createCriteria(entityClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }


}
