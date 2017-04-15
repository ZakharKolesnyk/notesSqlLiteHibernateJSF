package com.gmail.kolesnyk.zakhar.user;

import com.gmail.kolesnyk.zakhar.AbstractDao;
import com.gmail.kolesnyk.zakhar.config.TransactionUtil;
import com.gmail.kolesnyk.zakhar.notes.Note;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static com.gmail.kolesnyk.zakhar.config.TransactionUtil.getSession;
import static com.gmail.kolesnyk.zakhar.config.TransactionUtil.performTransaction;

public class UserDaoImpl extends AbstractDao<User,Integer> implements UserDao {

    @Override
    public User byLogin(String login) {
        return performTransaction(() -> (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult());
    }

    @Override
    public User byEmail(String email) {
        return performTransaction(() -> (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email)).uniqueResult());
    }
}
