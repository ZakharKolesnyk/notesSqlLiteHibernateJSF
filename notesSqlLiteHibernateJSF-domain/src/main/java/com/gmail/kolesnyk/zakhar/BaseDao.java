package com.gmail.kolesnyk.zakhar;


import java.util.List;

/**
 * The {@code UserDao} contains main methods that required for ORM relations
 *
 * @author Kolesnyk Zakhar
 * @see com.gmail.kolesnyk.zakhar.AbstractDao
 * @see com.gmail.kolesnyk.zakhar.user.UserDao
 * @see com.gmail.kolesnyk.zakhar.notes.NoteDao
 * @since JDK1.8
 */
public interface BaseDao<T, I> {

    /**
     * method allow to get entity by primary key of table
     *
     * @param id primary key of entity
     * @return entity
     */
    T byId(I id);

    /**
     * add new row what mapped entity in suited table
     *
     * @param object entity for saving
     */
    void save(T object);

    /**
     * update row where mapped entity in suited table
     *
     * @param object entity for updating
     */
    void update(T object);

    /**
     * remove row where mapped entity in suited table
     *
     * @param object entity for removing
     */
    void remove(T object);

    /**
     * return list of all entities from suited table
     *
     * @return {@link List<>} of entity
     */
    List<T> list();
}
