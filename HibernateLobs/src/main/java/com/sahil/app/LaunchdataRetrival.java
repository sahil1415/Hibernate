
package com.sahil.app;




import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sahil.model.Student02;





public class LaunchdataRetrival {

    public static void main(String[] args) {
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        FileOutputStream fos = null;
        FileWriter writer = null;

        try {
            // Creating configuration object
            config = new Configuration();
            config.configure();
            
            // Adding annotated classes
            config.addAnnotatedClass(Student02.class);
       
            
            sessionFactory = config.buildSessionFactory();
            session = sessionFactory.openSession();

            // Begin transaction
            transaction = session.beginTransaction();
            
            Student02 st = session.get(Student02.class, 1);
            
            try {
            	fos = new FileOutputStream("java.jpg");
            	writer = new FileWriter("abc.txt");
            	fos.write(st.getImageFile());
            	writer.write(st.getTextFile());
            }
            catch(FileNotFoundException fe) {
            	fe.printStackTrace();
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
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
            
            try {
				fos.close();
				writer.close();
			} catch (IOException ie) {
				// TODO Auto-generated catch block
				ie.printStackTrace();
			}
            catch(Exception e) {
            	e.printStackTrace();
            }
            
        }
    }
}

