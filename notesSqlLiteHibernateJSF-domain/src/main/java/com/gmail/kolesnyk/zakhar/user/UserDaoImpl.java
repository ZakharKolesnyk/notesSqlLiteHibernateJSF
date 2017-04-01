package com.gmail.kolesnyk.zakhar.user;

import com.gmail.kolesnyk.zakhar.AbstractDao;
import org.hibernate.criterion.Restrictions;

import static com.gmail.kolesnyk.zakhar.config.TransactionUtil.getSession;

public class UserDaoImpl extends AbstractDao<User,Integer> implements UserDao {

    @Override
    public User byLogin(String login) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }

    @Override
    public User byEmail(String email) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email)).uniqueResult();
    }
}
