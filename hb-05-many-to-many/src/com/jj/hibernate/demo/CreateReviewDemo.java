package com.jj.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jj.hibernate.demo.entity.Course;
import com.jj.hibernate.demo.entity.Instructor;
import com.jj.hibernate.demo.entity.InstructorDetail;
import com.jj.hibernate.demo.entity.Review;
import com.jj.hibernate.demo.entity.Student;


public class CreateReviewDemo {

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
			Course myCourse = session.get(Course.class, 10);
			
			Review review1= new Review("Amazing");
			Review review2= new Review("Outstanding!!!");
			
			myCourse.addReview(review1);
			myCourse.addReview(review2);
			
			session.save(review1);
			session.save(review2);
			
			
			session.getTransaction().commit();
			
		}finally {
			session.close();
			factory.close();
		}
	}

}
