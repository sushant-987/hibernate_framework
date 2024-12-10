package com.map1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo {

    public static void main(String[] args) {
        // Set up Hibernate session factory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Creating Employee entities
        Emp e1 = new Emp();
        Emp e2 = new Emp();

        e1.setEid(1001);
        e1.setName("Ram");

        e2.setEid(1002);
        e2.setName("Shyam");

        // Creating Project entities
        Project p1 = new Project();
        Project p2 = new Project();

        p1.setPid(12345);
        p1.setProjectName("Model Based System Engineering");
        p2.setPid(67890);
        p2.setProjectName("Learning Management System");

        // Adding projects to employee
        List<Project> list2 = new ArrayList<>();
        list2.add(p1);
        list2.add(p2);

        e1.setProjects(list2); // Assigning projects to employee e1

        // Adding employees to project
        List<Emp> list1 = new ArrayList<>();
        list1.add(e1);
        list1.add(e2);

        p1.setEmps(list1);  // Assigning employees to project p1
        p2.setEmps(list1);  // Assigning employees to project p2

        // Session handling and saving entities
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Save the entities to the database
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);

        tx.commit();

        // Fetching and displaying saved data
        Emp savedEmp = (Emp) session.get(Emp.class, 1001);
        System.out.println("Employee: " + savedEmp.getName());
        for (Project p : savedEmp.getProjects()) {
            System.out.println("Project: " + p.getProjectName());
        }

        // Close the session factory
        sessionFactory.close();
    }
}
