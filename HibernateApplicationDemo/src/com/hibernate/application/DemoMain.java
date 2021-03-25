package com.hibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class DemoMain {
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			
			//create student object 
			Student student = new Student("Deepesh", "Saraswat", "saraswatdeepesh19@gmail.com");
			
			//start new transaction
			session.beginTransaction();
			
			//save the student object 
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			factory.close();
		}
	}

}
