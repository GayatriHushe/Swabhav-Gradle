package com.techlabs.repository;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.model.Student;

@Repository

public class StudentRepository {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	

	public void addStudent(Student student) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
	}

	public List<Student> getStudents(){
		session=sessionFactory.openSession();
		List<Student> list= (List<Student>)session.createSQLQuery("SELECT * FROM STUDENT").addEntity(Student.class).list();
		System.out.println(list);
	    return list;
	}
	
	public void updateStudent(Student student) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();
		session.close();
	}
	
	public void deleteStudent(Student student) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.delete(student);
		
		transaction.commit();
		session.close();
	}
}
