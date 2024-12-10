package com.map.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Person person = new Person(23, "Ram", "Pune", "77743789");
	//	System.out.println(person);
		
		session.save(person);

		tx.commit();
		session.close();
		sf.close();
	}

}
