package com.techlab.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.techlabs.models.Customer;
import com.techlabs.models.Lineitem;
import com.techlabs.models.Orders;
import com.techlabs.models.Product;

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
	     
	      //Customers
	      Customer c1=new Customer();
	      c1.setCid(1);
	      c1.setCname("Gayatri");
	     
	      Customer c2=new Customer();
	      c2.setCid(2);
	      c2.setCname("Shruti");
	     
	      //Orders
	      Orders o1=new Orders();
	      o1.setOid(1);
	      o1.setDate("01-07-2021");
	      o1.setCust(c1);   
	      
	      Orders o2=new Orders();
	      o2.setOid(2);
	      o2.setDate("05-07-2021");
	      o2.setCust(c1);   
	      
	      Orders o3=new Orders();
	      o3.setOid(3);
	      o3.setDate("02-07-2021");
	      o3.setCust(c2);   
	      
	      //Lineitem
	      Lineitem l1=new Lineitem();
	      l1.setLid(1);
	      l1.setQty(2);
	      l1.setOrd(o1);
	      
	      Lineitem l2=new Lineitem();
	      l2.setLid(2);
	      l2.setQty(3);
	      l2.setOrd(o2);
	      
	      //Product
	      Product p1=new Product();
	      p1.setPid(1);
	      p1.setPname("pen");
	      p1.setPcost(12);
	      p1.setItem(l1);
	      
	      Product p2=new Product();
	      p2.setPid(2);
	      p2.setPname("book");
	      p2.setPcost(40);
	      p2.setItem(l2);
	      
	      Set<Product> product1=new HashSet<Product>();
	      product1.add(p1);
	      
	      Set<Product> product2=new HashSet<Product>();
	      product1.add(p2);
	      
	      
	      Set<Lineitem> lineitem1=new HashSet<Lineitem>();	      
	      lineitem1.add(l1);
	      
	      Set<Lineitem> lineitem2=new HashSet<Lineitem>();
	      lineitem2.add(l2);
	      
	      
	      Set<Orders> order1=new HashSet<Orders>();
	      order1.add(o1);
	      order1.add(o2);
	      
	      Set<Orders> order2=new HashSet<Orders>();
	      order2.add(o3);
	      
	      
	      l1.setProducts(product1);
	      l2.setProducts(product2);
	      
	      o1.setLineitems(lineitem1);
	      o2.setLineitems(lineitem2);
	      
	      c1.setOrders(order1);
	      c2.setOrders(order2);
	      
	      session.save(l1);
	      session.save(l2);
	      
	      session.save(o1);
	      session.save(o2);
	      
	      session.save(c1);
	      session.save(c2);
	      
	      
	      
	      txn.commit();
	  }

	
}
