package com.sahil.app;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.sahil.model.Employee;

public class LaunchHQL {

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

            // Begin transaction (if required for other operations)
            transaction = session.beginTransaction();
            
            // Select * from Employee
            // Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
            
            // Select * from Employee where e_age >= :age
            // Query<Employee> query = session.createQuery("FROM Employee WHERE e_age >= :age", Employee.class);
            // query.setParameter("age", 19);
            // List<Employee> listEmployee = query.list();
            // for (Employee e : listEmployee) {
            //     System.out.println(e);
            // }
            
            // Select e_name from Employee where e_age = :age
            Query<String> query = session.createQuery("SELECT e_name FROM Employee WHERE e_age = :age",String.class);
            query.setParameter("age", 19); // Ensure data type matches
            List<String> list = query.list();
            
            for (String s : list) {
                System.out.println(s);
            }
            
            // Commit transaction (if it was used)
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
