package com.sahil.app;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.model.Employee;


public class LaunchUpdate {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		org.hibernate.Transaction transaction = null;
		boolean flag = false;
		
		try {
			config = new Configuration();
			config.configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			System.out.println("Creating the class object");
			Employee emp = new Employee();
			
			emp.setE_id(5);
			emp.setE_name("Shivraj Singh");
			emp.setE_city("Chandigarh");
			
			System.out.println("Saving the object in the table");
			session.merge(emp);
			flag = true;
			System.out.println("Object Saved");
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag == true) {
				transaction.commit();
				System.out.println("Transaction Commited");
			}
			else {
				transaction.rollback();
				System.out.println("Transaction Rolled Back");
				
			}
		}
	
	}

}
