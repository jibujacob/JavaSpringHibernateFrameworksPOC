package com.jj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jj.hibernate.demo.entity.Course;
import com.jj.hibernate.demo.entity.Instructor;
import com.jj.hibernate.demo.entity.InstructorDetail;
import com.jj.hibernate.demo.entity.Review;
import com.jj.hibernate.demo.entity.Student;


public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			Student myStudent = session.get(Student.class, 2);
			
			session.delete(myStudent);
			
			session.getTransaction().commit();
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
