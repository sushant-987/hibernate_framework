package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Hibernate Object States
		// 1.Transient
		// 2.Persistent
		// 3.detached
		// 4.removed

		System.out.println("Example: ");

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Creating student object:
		Student student = new Student();
		student.setId(12345);
		student.setName("Peter");
		student.setCity("Latur");
		student.setCerti(new Certificate("Java Hibernate Course", "6 months"));
		// student : Transient

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		// student: Persistent - session, database
		student.setName("John");

		tx.commit();
		
		s.close();
		
	//student : Detached	
		student.setName("Sam");
		System.out.println(student);

		sf.close();
		
	}

}
