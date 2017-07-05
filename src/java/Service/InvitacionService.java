/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HibernateUtil;
import Entity.Invitacion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InvitacionService {
    
    public static List<Invitacion> list(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Invitacion");
        return query.list();
    }
    
    public static Invitacion getByToken(String token){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Invitacion where Reserva.token=:token");
            query.setParameter("token", token);
            Invitacion invitacione = (Invitacion) query.list().get(0);
            session.close();
            return invitacione;
        } catch(Exception e){
            System.err.println(e);
            return null;
        }
        
    }
    
    public static void add(Invitacion invitacion){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(invitacion);
        tx.commit();
        session.close();
    }
}
