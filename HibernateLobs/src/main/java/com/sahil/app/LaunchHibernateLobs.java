
package com.sahil.app;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sahil.model.Student02;





public class LaunchHibernateLobs {

    public static void main(String[] args) {
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        FileInputStream fis = null;
        byte image[] = null;
        File file = null;
        FileReader reader = null;
        char txt[] = null;

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
            
            try {
            	// getting the image from local device using i/o
            	fis = new FileInputStream("C:\\Users\\sahil\\Desktop\\New folder\\lap.jpg");
//            	reading the image in the array
            	image = new byte[fis.available()];
            	fis.read();  
            	
            	file = new File("C:\\Users\\sahil\\Desktop\\New folder\\abc.txt");
            	reader = new FileReader(file);
            	txt = new char[(int)file.length()];
            	reader.read();
            	
            }
            catch(FileNotFoundException fe) {
            	fe.printStackTrace();
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
            
            Student02 s1 = new Student02();
            s1.setS_name("Sahil Ansari");
            s1.setImageFile(image);
            s1.setTextFile(txt);
            
            session.persist(s1);
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
				fis.close();
				reader.close();
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

