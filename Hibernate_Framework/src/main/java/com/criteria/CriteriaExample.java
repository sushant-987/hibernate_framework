package com.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;
import java.util.List;

public class CriteriaExample {

    public static void main(String[] args) {
        // Initialize Hibernate session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        // Creating a HQL query to fetch all students
        Query<Student> query = session.createQuery("FROM Student", Student.class);
        List<Student> students = query.list();
        
        // Print the results
        for (Student st : students) {
            System.out.println(st);
        }
        
        // Closing the session
        session.close();
        sessionFactory.close();
    }
}
