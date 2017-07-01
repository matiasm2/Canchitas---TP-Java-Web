/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HibernateUtil;
import Entity.Hora;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HoraService {
    
    public static List<Hora> list(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Hora");
        return query.list();
    }
    
    public static Hora getByHora(String hora){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Hora where hora=:hora");
            query.setParameter("hora", hora);
            Hora horae = (Hora) query.list().get(0);
            session.close();
            return horae;
        } catch(Exception e){
            System.err.println(e);
            return null;
        }
        
    }
    
    public static void add(Hora hora){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(hora);
        tx.commit();
        session.close();
    }
}
