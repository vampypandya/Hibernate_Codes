package com.javatpoint.mypackage;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StoreData {
	private static SessionFactory factory; 
	public static void main(String[] args) {
		//StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		//Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		//SessionFactory factory = meta.getSessionFactoryBuilder().build();
		factory = new Configuration().addAnnotatedClass(Employee.class).configure().buildSessionFactory();
                
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setId((long) 1);
		e1.setFirstName("Gaurav");
		e1.setLastName("Chawla");

		session.save(e1);
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}
}