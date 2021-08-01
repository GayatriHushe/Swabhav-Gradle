package com.techlabs.test;

import java.util.List;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.techlabs.models.Talent;

public class Test {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

		System.out.println(configuration);
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		System.out.println(session.getClass());
		Transaction txn = session.beginTransaction();
		Talent t1 = new Talent(1, "Gayatri", 9.57f);
		Talent t2 = new Talent(2, "abc", 9f);
		Talent t3 = new Talent(3, "def", 9.2f);
		Talent t4 = new Talent(4, "ghi", 8.57f);

		System.out.println("Insert : ");
		session.save(t1);
		session.save(t3);
		session.save(t4);
		printInfo(session);
		
		System.out.println("Update : ");
		t2.setName("abcd");
		session.saveOrUpdate(t2);
		
		
		session.saveOrUpdate(t2);
		printInfo(session);
		
		System.out.println("Delete : ");
		session.delete(t3);
		printInfo(session);
		
		txn.commit();

		session.close();

	}

	private static void printInfo(Session session) {
		List < Talent > talents = session.createQuery("from Talent").list();
		for (Talent talent : talents) {
			System.out.println("Id : "+talent.getId());
			System.out.println("Name : "+talent.getName());
			System.out.println("Cgpa : "+talent.getCgpa());
			System.out.println();
		}
		
	}
}
