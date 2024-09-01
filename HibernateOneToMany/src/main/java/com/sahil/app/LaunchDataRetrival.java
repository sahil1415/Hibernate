package com.sahil.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.model.AnswerTable;
import com.sahil.model.QuestionTable;

public class LaunchDataRetrival {

    public static void main(String[] args) {
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;

        try {
            // Creating configuration object
            config = new Configuration();
            config.configure();

            // Adding annotated classes
            config.addAnnotatedClass(QuestionTable.class);
            config.addAnnotatedClass(AnswerTable.class);

            sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();

            // Fetching a question with ID 1
            QuestionTable question = session.get(QuestionTable.class, 1);
            System.out.println(question);

            // Printing associated answers
            List<AnswerTable> answer = question.getAnswerList();
            for(AnswerTable at : answer) {
            	System.out.println(at);
            }
//            for (AnswerTable answer : question.getAnswerList()) {
//                System.out.println(answer);
//            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }
    }
}
