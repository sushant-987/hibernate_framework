package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query; // Correct import for Hibernate's Query
import com.tut.Student;

public class HQLExample {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Perform CRUD Operations
        createStudent(sessionFactory);
        readStudents(sessionFactory);
        updateStudent(sessionFactory, 1234, "Updated Name");
        deleteStudent(sessionFactory, 1234);

        // Close the session factory
        sessionFactory.close();
    }

    // CREATE Operation
    private static void createStudent(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Check if a student with the same ID already exists
            Student existingStudent = session.get(Student.class, 1234);
            if (existingStudent != null) {
                System.out.println("Student with ID 1234 already exists: " + existingStudent.getName());
                return;
            }

            // Create a new student
            Student student = new Student();
            student.setId(1234); // Ensure this ID is unique
            student.setName("John Doe");
            student.setCity("New York");

            session.save(student);
            transaction.commit();
            System.out.println("Student created successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // READ Operation
    private static void readStudents(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        // HQL query to fetch all students
        String query = "from Student";
        Query<Student> q = session.createQuery(query, Student.class);

        List<Student> students = q.getResultList();

        // Print student details
        for (Student student : students) {
            System.out.println(student.getId() + " : " + student.getName() + " : " + student.getCity());
        }

        session.close();
    }

    // UPDATE Operation
    private static void updateStudent(SessionFactory sessionFactory, int id, String newName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL query to update the student's name
        String query = "update Student set name = :name where id = :id";
        Query<?> q = session.createQuery(query);
        q.setParameter("name", newName);
        q.setParameter("id", id);

        int result = q.executeUpdate(); // Execute the update query
        transaction.commit();
        session.close();

        if (result > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("No student found with the given ID.");
        }
    }

    // DELETE Operation
    private static void deleteStudent(SessionFactory sessionFactory, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL query to delete the student
        String query = "delete from Student where id = :id";
        Query<?> q = session.createQuery(query);
        q.setParameter("id", id);

        int result = q.executeUpdate(); // Execute the delete query
        transaction.commit();
        session.close();

        if (result > 0) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("No student found with the given ID.");
        }
    }
}
