package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// Configuration setup
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// Creating a question
		Question q1 = new Question();
		q1.setQuestionId(341); // Set the question ID
		q1.setQuestion("What is Java?");

		// Creating answers
		Answer a1 = new Answer();
		a1.setAnswerId(245);
		a1.setAnswer("Java is a Programming language");
		a1.setQuestion(q1);

		Answer a2 = new Answer();
		a2.setAnswerId(246);
		a2.setAnswer("Java is an OOP language.");
		a2.setQuestion(q1);

		Answer a3 = new Answer();
		a3.setAnswerId(247);
		a3.setAnswer("Java has different types of frameworks.");
		a3.setQuestion(q1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		q1.setAnswer(list); // Set the answers for the question

		// Session
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Save the question and answers to the database
		// session.save(q1);

		Question q = (Question) session.get(Question.class, 341);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().size());

		// Commit the transaction
		tx.commit();
		

		/*
		 * // Fetch the question using the correct ID Question qs = (Question)
		 * session.get(Question.class, 341); // Correct ID
		 * 
		 * if (qs != null) { System.out.println("Question: " + qs.getQuestion()); for
		 * (Answer a : qs.getAnswer()) { System.out.println("Answer: " + a.getAnswer());
		 * } } else { System.out.println("Question with ID 340 not found."); }
		 */

		// Closing session and session factory
		session.close();
		sessionFactory.close();
	}
}
