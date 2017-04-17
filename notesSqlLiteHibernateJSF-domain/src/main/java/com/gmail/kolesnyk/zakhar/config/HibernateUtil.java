package com.gmail.kolesnyk.zakhar.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * The {@code TransactionUtil} singleton class using for building hibernate session factory
 *
 * @author Kolesnyk Zakhar
 * @see com.gmail.kolesnyk.zakhar.config.TransactionUtil
 * @since JDK1.8
 */
class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }

    static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}