package com.sahil.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.model.FacultyInfo1;

public class LaunchGeneratedValue {
    public static void main(String[] args) {
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        org.hibernate.Transaction transaction = null;
        boolean flag = false;

        // Mapping the class 
        config = new Configuration();
        config.configure();
        config.addAnnotatedClass(FacultyInfo1.class);
        
        // Remove the duplicate declaration
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        FacultyInfo1 f1 = new FacultyInfo1();
        f1.setE_name("Sameer Ansari");
        f1.setE_age(19);
        f1.setE_email("sahilansari@gmail.com");
        f1.setE_city("Mohali");

        try {
            transaction = session.beginTransaction();
            session.persist(f1);
            flag = true;
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                transaction.commit();
                System.out.println("Transaction Committed");
            } else {
                transaction.rollback();
                System.out.println("Transaction Rolled Back");
            }
            // Properly close resources
            session.close();
            sessionFactory.close();
        }
    }
}

