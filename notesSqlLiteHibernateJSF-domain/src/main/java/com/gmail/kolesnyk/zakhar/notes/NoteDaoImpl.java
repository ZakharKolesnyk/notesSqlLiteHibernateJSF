package com.gmail.kolesnyk.zakhar.notes;

import com.gmail.kolesnyk.zakhar.AbstractDao;
import com.gmail.kolesnyk.zakhar.config.TransactionUtil;
import com.gmail.kolesnyk.zakhar.user.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static com.gmail.kolesnyk.zakhar.config.TransactionUtil.getSession;
import static com.gmail.kolesnyk.zakhar.config.TransactionUtil.performTransaction;

public class NoteDaoImpl extends AbstractDao<Note, Integer> implements NoteDao {
    @Override
    @SuppressWarnings("unchecked")
    public List<Note> byState(STATE state) {
        return performTransaction(() -> (List<Note>) getSession().createCriteria(Note.class)
                .add(Restrictions.eq("state", state)).addOrder(Order.asc("createDate")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
//        return (List<Note>) getSession().createCriteria(Note.class)
//                .add(Restrictions.eq("state", state)).addOrder(Order.asc("createDate")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Note> byStateSublist(STATE state, int amount, int  indexStart) {
        return performTransaction(() -> (List<Note>) getSession().createSQLQuery
                ("SELECT * FROM notes WHERE state=:state ORDER BY create_date ASC LIMIT :amount OFFSET :indexStart ;")
                .addEntity(Note.class).setParameter("state", state.ordinal()).setParameter("indexStart", indexStart).setParameter("amount", amount).list());
//        return (List<Note>) getSession().createSQLQuery
//                    ("SELECT * FROM notes WHERE state=:state ORDER BY create_date ASC LIMIT :amount OFFSET :indexStart ;")
//                .addEntity(Note.class).setParameter("state", state.ordinal()).setParameter("indexStart", indexStart).setParameter("amount", amount).list();
    }
}