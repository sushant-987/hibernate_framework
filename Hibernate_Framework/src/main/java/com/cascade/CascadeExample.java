package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Question q1 = new Question();

		q1.setQuestionId(999);
		q1.setQuestion("What is Spring Boot framework?");

		Answer a1 = new Answer(23412, "In hibernate it is important concept");
		Answer a2 = new Answer(8765, "second answer");
		Answer a3 = new Answer(5436, "third answer");

		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswer(list);
		Transaction tx = s.beginTransaction();
		s.save(q1);

		tx.commit();

		s.close();
		sf.close();

	}

}
