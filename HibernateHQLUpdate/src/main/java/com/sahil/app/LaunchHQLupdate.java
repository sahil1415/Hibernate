package com.sahil.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.sahil.model.Employee;

public class LaunchHQLupdate {

    public static void main(String[] args) {
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try {
            // Creating configuration object
            config = new Configuration();
            config.configure();
            
            // Adding annotated classes
            config.addAnnotatedClass(Employee.class);
            
            sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();

            // Begin transaction
            transaction = session.beginTransaction();
            
            // Update query
            Query<?> query = session.createQuery("UPDATE Employee SET city = :c1 WHERE city = :c2");
            query.setParameter("c1", "Mohali");
            query.setParameter("c2", "Chandigarh");
            
            // Execute the update
            int result = query.executeUpdate();
            System.out.println(result + " records updated.");
            
            // Commit transaction
            flag = true;

        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                if (transaction != null) transaction.commit();
                System.out.println("Transaction Committed");
            } else {
                if (transaction != null) transaction.rollback();
                System.out.println("Transaction Rolled Back");
            }
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }
    }
}
