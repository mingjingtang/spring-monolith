package com.ga.dao;

import com.ga.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Course createCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return course;
    }

    @Override
    public List<Course> listCourses() {
        List<Course> allCourse = null;
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            allCourse = session.createQuery("FROM Course").getResultList();
        }
        finally {
            session.close();
        }
        return allCourse;
    }
}
