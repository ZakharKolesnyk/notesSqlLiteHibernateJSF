package com.gmail.kolesnyk.zakhar.user;

import com.gmail.kolesnyk.zakhar.BaseDao;

public interface UserDao extends BaseDao<User, Integer> {

    User byLogin(String login);

    User byEmail(String email);
}
