
package com.sahil.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sahil.model.Courses01;
import com.sahil.model.Student01;



public class LaunchManyToMany {

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
            config.addAnnotatedClass(Student01.class);
            config.addAnnotatedClass(Courses01.class);
            
            sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();

            // Begin transaction
            transaction = session.beginTransaction();
            
            Courses01 c1 = new Courses01();
            c1.setC_id(1);
            c1.setC_name("Hibernate");
            c1.setC_price(1999);
            
            Courses01 c2 = new Courses01();
            c2.setC_id(2);
            c2.setC_name("Java");
            c2.setC_price(9999);
            
            Courses01 c3 = new Courses01();
            c3.setC_id(3);
            c3.setC_name("SpringBoot");
            c3.setC_price(19999);
            
            Set<Courses01> set1 = new HashSet<>();
            set1.add(c1);
            set1.add(c2);
            set1.add(c3);
            
            Set<Courses01> set2 = new HashSet<>();
            set2.add(c1);
            set2.add(c2);
            
            Student01 s1 = new Student01();
            s1.setS_id(1);
            s1.setS_name("Sahil Ansari");
            s1.setCourse(set2);
            
            Student01 s2 = new Student01();
            s2.setS_id(2);
            s2.setS_name("Sameer Ansari");
            s2.setCourse(set1);
            
            Student01 s3 = new Student01();
            s3.setS_id(3);
            s3.setS_name("Ansh Kant");
            s3.setCourse(set1);
            
            session.persist(s1);
            session.persist(s2);
            session.persist(s3);
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
                if (transaction != null) transaction.rollback();
                System.out.println("Transaction Rolled Back");
            }
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }
    }
}

