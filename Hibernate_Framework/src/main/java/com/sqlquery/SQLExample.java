package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {

    public static void main(String[] args) {
        // Set up the session factory
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        // Open a session
        Session s = sf.openSession();

        String q = "SELECT id, name, city FROM student";

        NativeQuery<Object[]> nq = s.createNativeQuery(q);

        List<Object[]> list = nq.getResultList();

        for (Object[] student : list) {
            System.out.println(Arrays.toString(student));
        }


        // Close session and session factory
        s.close();
        sf.close();
    }
}
