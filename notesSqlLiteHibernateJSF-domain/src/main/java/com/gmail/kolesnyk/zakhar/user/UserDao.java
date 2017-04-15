package com.gmail.kolesnyk.zakhar.user;

import com.gmail.kolesnyk.zakhar.BaseDao;


/**
 * The {@code UserDao} class DAO for entity {@link User}
 *
 * @author Kolesnyk Zakhar
 * @see com.gmail.kolesnyk.zakhar.AbstractDao
 * @see com.gmail.kolesnyk.zakhar.user.UserDaoImpl
 * @since JDK1.8
 */
public interface UserDao extends BaseDao<User, Integer> {

    /**
     * method allow to get {@link User} by login
     *
     * @param login login of {@link User}
     * @return {@link User}
     */
    User byLogin(String login);

    /**
     * method allow to get {@link User} by email
     *
     * @param email email of {@link User}
     * @return {@link User}
     */
    User byEmail(String email);
}
