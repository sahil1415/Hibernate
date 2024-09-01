package com.sahil.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sahil.model.FacultyInfo;

public class GetData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
            .configure() // reads hibernate.cfg.xml
            .addAnnotatedClass(FacultyInfo.class)
            .buildSessionFactory();

        Session session1 = null;
        Session session2 = null;
        Transaction transaction = null;
        // Configuration without xml file
        
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(FacultyInfo.class);
//        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/java_db");
        try {
            session1 = sessionFactory.openSession();
            session2 = sessionFactory.openSession();
//            transaction = session1.beginTransaction();

            // Retrieve the entity
            // hibernate give me a object whose id is 1
//            FacultyInfo facultyInfo = session.get(FacultyInfo.class, 1); // early or eager loadidng
//            FacultyInfo facultyInfo = session.load(FacultyInfo.class, 1); // lazy loading
            FacultyInfo facultyInfo = session1.getReference(FacultyInfo.class, 1); // lazy loading
            System.out.println(facultyInfo);
            FacultyInfo facultyInfo1 = session1.getReference(FacultyInfo.class, 1);
            System.out.println(facultyInfo1);
            FacultyInfo facultyInfo2 = session2.getReference(FacultyInfo.class, 2);
            System.out.println(facultyInfo2);
            FacultyInfo facultyInfo3 = session2.getReference(FacultyInfo.class, 2);
            System.out.println(facultyInfo3);
            

//            if (facultyInfo != null) {
//                // Print the retrieved entity
////                System.out.println("Retrieved FacultyInfo: " + facultyInfo);
//                System.out.println("Id - "+facultyInfo.getE_id());
//                System.out.println("Name - "+facultyInfo.getE_name());
//                System.out.println("Age - "+facultyInfo.getE_age());
//                System.out.println("Email - "+facultyInfo.getE_email());
//            } else {
//                System.out.println("No data found for the provided ID.");
//            }

            transaction.commit(); // Commit transaction
        } 
        catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback(); // Rollback transaction in case of error
            }
            he.printStackTrace();
        } 
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback transaction in case of error
            }
            e.printStackTrace();
        } 
        finally {
            session2.close();
            session1.close(); // Close session
            sessionFactory.close(); // Close sessionFactory
        }
    }
}
