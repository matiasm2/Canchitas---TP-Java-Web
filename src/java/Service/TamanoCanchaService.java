/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HibernateUtil;
import Entity.Tamanocancha;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TamanoCanchaService {
    
    
    public static Tamanocancha getByName(String tamanocancha){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Tamanocancha where tamanocancha=:tamanocancha");
            query.setParameter("tamanocancha", tamanocancha);
            Tamanocancha tamano = (Tamanocancha) query.list().get(0);
            session.close();
            return tamano;
        } catch(Exception e){
            System.err.println(e);
            return null;
        }
        
    }
    
    public static void add(Tamanocancha tamanocancha){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(tamanocancha);
        tx.commit();
        session.close();
    }
}
