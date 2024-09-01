package com.sahil.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sahil.model.Faculty;

public class LaunchSelective {
	public static void main(String args[]) {
		SessionFactory sessionFactory = new Configuration().configure().
				addAnnotatedClass(Faculty.class).buildSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Faculty f1 = new Faculty();
			f1.setId(1);
			f1.setName("Sahil Ansari");
			f1.setDepartment("CSE");
			f1.setLevel(5);
			session.persist(f1);
			
			flag = true;
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
