package com.jj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jj.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			Student student =new Student("John1","Doe1","johndoe1@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student studenttemp = session.get(Student.class, student.getId());
			System.out.println(studenttemp);
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
