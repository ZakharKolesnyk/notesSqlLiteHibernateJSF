package com.gmail.kolesnyk.zakhar.config;

import org.hibernate.Session;

/**
 * The {@code TransactionUtil} class using for wrapping methods of DAO classes in transactions
 *
 * @author Kolesnyk Zakhar
 * @see com.gmail.kolesnyk.zakhar.config.HibernateUtil
 * @see com.gmail.kolesnyk.zakhar.AbstractDao
 * @see com.gmail.kolesnyk.zakhar.user.UserDao
 * @see com.gmail.kolesnyk.zakhar.notes.NoteDao
 * @since JDK1.8
 */
public class TransactionUtil {

    private static volatile Session session;

    /**
     * method invoking {@link Transaction#perform()} in one transaction context
     *
     * @param transaction class contains one method perform()
     */
    public static <T> T performTransaction(Transaction<T> transaction) {
        Object dst;
        try {
            dst = transaction.perform();
            session.getTransaction().commit();
            return (T) dst;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * @return initialized session with opened transaction
     */
    public static Session getSession() {
        initSession();
        return session;
    }

    private static void initSession() {
        if (HibernateUtil.getSessionFactory().isClosed()) {
            session = HibernateUtil.getSessionFactory().openSession();
        } else {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }
    }

    /**
     * The {@code Transaction} class using for performing own method in transaction contexts
     *
     * @author Kolesnyk Zakhar
     * @see com.gmail.kolesnyk.zakhar.config.HibernateUtil
     * @see com.gmail.kolesnyk.zakhar.AbstractDao
     * @see com.gmail.kolesnyk.zakhar.user.UserDaoImpl
     * @see com.gmail.kolesnyk.zakhar.notes.NoteDaoImpl
     * @since JDK1.8
     */
    public interface Transaction<T> {
        T perform();
    }
}