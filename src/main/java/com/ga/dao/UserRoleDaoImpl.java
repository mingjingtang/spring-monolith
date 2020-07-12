package com.ga.dao;

import com.ga.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserRole createUserRole(UserRole newRole) {
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            session.save(newRole);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return newRole;
    }

    @Override
    public UserRole getUserRole(String rolename) {
        UserRole userRole = null;
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            userRole = (UserRole)session.createQuery("FROM UserRole r WHERE r.name = '"+ rolename + "'").uniqueResult();
        }
        finally {
            session.close();
        }
        return userRole;
    }
}
