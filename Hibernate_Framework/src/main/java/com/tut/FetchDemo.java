package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// get, load

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// get-student:102
		
		  Student student = (Student)session.load(Student.class, 103);
		  Student student1 = (Student)session.load(Student.class, 103);
		  System.out.println(student.getCity());
		  System.out.println(student1.getName());
		 

		/*
		 * Address ad = (Address) session.get(Address.class, 2);
		 * System.out.println(ad.getStreet());
		 * 
		 * Address ad1 = (Address) session.get(Address.class, 2);
		 * System.out.println(ad1.getStreet());
		 */

		session.close();
		sessionFactory.close();
	}

}
