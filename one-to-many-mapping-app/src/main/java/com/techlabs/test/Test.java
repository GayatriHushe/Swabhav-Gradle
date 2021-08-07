package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.techlabs.models.Department;
import com.techlabs.models.Employee;

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
      
      Department d=new Department();
      d.setDeptno(10);
      d.setDname("Sales");
      d.setLocation("Mumbai");
      
      Employee e1=new Employee("abc"); 
      Employee e2=new Employee("def");
      e1.setDept(d);
      e2.setDept(d);
      
      Set<Employee> emps=new HashSet<Employee>();
      emps.add(e1);
      emps.add(e2);
      d.setEmps(emps);
      session.save(d);
      txn.commit();
  }

}