package com.sahil.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sahil.model.Answer;
import com.sahil.model.Question;

public class LaunchOneToOne {

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

            // Creating question and answer objects
            Question q1 = new Question();
            q1.setId(2);
            q1.setQuestion("What is JPA");
            
            Answer a1 = new Answer();
            a1.setId(2);
            a1.setAnswer("Java persistent API is specification of JAVA which is used to establish relationship between object and relational database");
            
            // Setting relationship
            q1.setAnswer(a1);
            a1.setQuestion(q1);

            // Persisting objects
            session.persist(q1);
            session.persist(a1);

            // Committing transaction
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

