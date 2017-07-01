/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HibernateUtil;
import Entity.Cancha;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CanchaService {
    
    
    public static Cancha getByName(String nombre){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Cancha where nombre=:nombre");
            query.setParameter("nombre", nombre);
            Cancha canchae = (Cancha) query.list().get(0);
            session.close();
            return canchae;
        } catch(Exception e){
            System.err.println(e);
            return null;
        }
        
    }
    
    public static void add(Cancha cancha){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(cancha);
        tx.commit();
        session.close();
    }
}
