package com.gmail.kolesnyk.zakhar.config;

import org.hibernate.Session;

public class TransactionUtil {
    private static volatile Session session = HibernateUtil.getSessionFactory().openSession();

    public static void performTransaction(UpdateTransaction transaction) {
        try {
            transaction.transact();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public static  <T> T performTransaction(ReadTransaction<T> transaction) {
        Object dst;
        try {
            dst = transaction.transact();
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

    public interface UpdateTransaction {
        void transact();
    }

    public interface ReadTransaction<T> {
        T transact();
    }
}