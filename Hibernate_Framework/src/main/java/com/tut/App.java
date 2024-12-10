package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)throws IOException {
		System.out.println("Project Started..!!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		System.out.println(sessionFactory);
		System.out.println(sessionFactory.isClosed());

		// Creating Object of Student class
		Student st = new Student();
		st.setId(104);
		st.setName("Radha");
		st.setCity("Dwarka");
		System.out.println(st);

		// creating object of Address class

		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("Pune");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.345);

		
	// Reading Image 
		
	FileInputStream fis = new FileInputStream("src/main/java/com/tut/pic.jpg ");	
		byte[] data = new byte[fis.available()];	                    
		fis.read(data);
		ad.setImage(data);
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done...");

	}
}
