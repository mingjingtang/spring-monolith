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

    @Override
    public User deleteUser(Long userId) {
        User deletedUser = null;
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            deletedUser = session.get(User.class, userId);

            session.delete(deletedUser);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
        return deletedUser;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            user = (User) session.createQuery("FROM User u WHERE u.username = '" + username + "'").uniqueResult();
        }
        finally {
            session.close();
        }
        return user;
    }

}
