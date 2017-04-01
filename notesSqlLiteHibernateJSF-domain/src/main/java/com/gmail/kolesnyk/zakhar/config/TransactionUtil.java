package com.gmail.kolesnyk.zakhar.config;

import org.hibernate.Session;

public class TransactionUtil {
    private static volatile Session session = HibernateUtil.getSessionFactory().openSession();

    public static void doTransaction(Transaction transaction) {
        initSession();
//        session.getTransaction().begin();
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

    public static Session getSession() {
        initSession();
        return session;
    }

    private static void initSession() {
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//        }catch (HibernateException e){
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//        }
//        if (session.getTransaction().isActive()){
//            session.getTransaction().rollback();
//        }
        if (HibernateUtil.getSessionFactory().isClosed()) {
            session = HibernateUtil.getSessionFactory().openSession();
        } else {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }

    }

    public static void setSession(Session session) {
        TransactionUtil.session = session;
    }

    public interface Transaction {
        void transact();
    }
}