package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query; // Correct import for Query
import com.tut.Student;

public class HQLPagination {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// Execute query with type-safe method
		Query<Student> query = session.createQuery("from Student", Student.class);

		// Implementing pagination using Hibernate
		query.setFirstResult(0); // Starting from the first record
		query.setMaxResults(5); // Fetching 5 records only

		// Fetch the results
		List<Student> list = query.list();

		for (Student student : list) {
			System.out.println(student.getId() + " : " + student.getName() + " : " + student.getCity());
		}

		session.close();
		sessionFactory.close();
	}
}
