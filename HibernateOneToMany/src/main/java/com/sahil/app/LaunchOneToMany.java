
package com.sahil.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sahil.model.AnswerTable;
import com.sahil.model.QuestionTable;

public class LaunchOneToMany {

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
            config.addAnnotatedClass(QuestionTable.class);
            config.addAnnotatedClass(AnswerTable.class);
            
            sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();

            // Begin transaction
            transaction = session.beginTransaction();

            // Creating question and answer objects
            QuestionTable q1 = new QuestionTable();
            q1.setId(2);
            q1.setQuestion("What is JPA?");
            
            AnswerTable a1 = new AnswerTable();
            a1.setId(3);
            a1.setAnswer("JPA is JAVA persistence API.");
            a1.setQuestionTable(q1);
            
            AnswerTable a2 = new AnswerTable();
            a2.setId(4);
            a2.setAnswer("It is an specification of JAVA");
            a2.setQuestionTable(q1);
            
            
            List<AnswerTable> answers = new ArrayList<AnswerTable>();
            
            answers.add(a1);
            answers.add(a2);
            
            q1.setAnswerList(answers);
            
            //saving the changes
            session.persist(q1);
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

