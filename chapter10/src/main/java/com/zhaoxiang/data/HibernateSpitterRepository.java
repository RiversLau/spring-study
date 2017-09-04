package com.zhaoxiang.data;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Author: Rivers
 * Date: 2017/9/5 06:39
 */
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int count() {

        String hql = "select distinct id from AdminUser";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list().size();
    }
}
