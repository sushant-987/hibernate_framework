package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class SecondCacheExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();
		// first
		Student student1 = s.get(Student.class, 12345);
		System.out.println(student1);

		s.close();

		Session s2 = sf.openSession();
		// second level cache
		// dependency version mismatching please check properly in pom.xml

		Student student2 = s2.get(Student.class, 123);
		System.out.println(student2);
		s2.close();

		s.close();

		sf.close();

	}

}
