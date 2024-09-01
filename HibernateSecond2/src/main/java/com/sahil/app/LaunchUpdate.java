package com.sahil.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import com.sahil.model.Employee;

public class LaunchUpdate {

    public static void main(String[] args) {
        System.out.println("Starting Hibernate application...");

        // Load Hibernate configuration and add annotated class
        Configuration config = new Configuration();
        config.configure(); // Loads hibernate.cfg.xml
        config.addAnnotatedClass(Employee.class); // Ensure entity is added

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try {
            System.out.println("Building SessionFactory...");
            sessionFactory = config.buildSessionFactory();

            System.out.println("Opening session...");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            System.out.println("Creating student object...");
            Employee s = new Employee();
            s.setSid(13);
            s.setSname("Ansh");
            s.setScity("Noida");

            System.out.println("Updating student...");
            session.update(s);
            flag = true;
            System.out.println("Student updated successfully.");
        } catch (HibernateException he) {
            System.err.println("HibernateException occurred: " + he.getMessage());
            he.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (flag) {
                    System.out.println("Committing transaction...");
                    transaction.commit();
                } else {
                    System.out.println("Rolling back transaction...");
                    if (transaction != null) {
                        transaction.rollback();
                    }
                }
            } catch (Exception e) {
                System.err.println("Exception during commit/rollback: " + e.getMessage());
                e.printStackTrace();
            }
            if (session != null) {
                System.out.println("Closing session...");
                session.close();
            }
            if (sessionFactory != null) {
                System.out.println("Closing SessionFactory...");
                sessionFactory.close();
            }
        }
        System.out.println("Hibernate application finished.");
    }
}
