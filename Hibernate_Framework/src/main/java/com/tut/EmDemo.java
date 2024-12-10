package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Student st1 = new Student();
		st1.setId(2345);
		st1.setName("Durgesh Tiwari");
		st1.setCity("Lucknow");

		Certificate certi = new Certificate();
		certi.setCourse("Java Programming");
		certi.setDuration("6 months");
		st1.setCerti(certi);

		Student st2 = new Student();
		st1.setId(2345);
		st1.setName("Premanand");
		st1.setCity("Vrundavan");

		Certificate certi1 = new Certificate();
		certi.setCourse("Sprirituality");
		certi.setDuration("60 years");
		st2.setCerti(certi1);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// objects to save
		session.save(st1);
		session.save(st2);

		session.close();
		sessionFactory.close();
		

	}

}
