package com.ga.dao;

import com.ga.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<User> listUsers() {
        List<User> allUsers = null;

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            allUsers = session.createQuery("FROM User").getResultList();
        }
        finally {
            session.close();
        }
        return allUsers;
    }

    @Override
    public User signup(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(user);

            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User login(User user) {
        User returnUser = null;
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            returnUser = (User) session.createQuery("FROM User u WHERE u.username = '" +
                    user.getUsername() + "' AND u.password = '" +
                    user.getPassword() + "'").getSingleResult();
        }
        finally {
            session.close();
        }
        return returnUser;
    }

    @Override
    public User updateUser(User user, Long userId) {
        User returnUser = null;
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            returnUser = session.get(User.class, userId);
            returnUser.setPassword(user.getPassword());

            session.update(returnUser);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return returnUser;
    }

}
