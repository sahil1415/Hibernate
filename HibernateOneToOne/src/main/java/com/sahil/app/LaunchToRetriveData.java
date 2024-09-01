
package com.sahil.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sahil.model.Answer;
import com.sahil.model.Question;

public class LaunchToRetriveData  {

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
            config.addAnnotatedClass(Question.class);
            config.addAnnotatedClass(Answer.class);
            
            sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();

            // Begin transaction
            transaction = session.beginTransaction();
            
            Question q1 = session.get(Question.class, 1);
            System.out.println(q1);
           System.out.println(q1.getId());
           System.out.println(q1.getQuestion());
           System.out.println(q1.getAnswer());
            

        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (flag) {
//                transaction.commit();
//                System.out.println("Transaction Committed");
//            } else {
//                if (transaction != null) transaction.rollback();
//                System.out.println("Transaction Rolled Back");
//            }
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }
    }
}

