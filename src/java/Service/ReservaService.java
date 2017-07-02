/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Cancha;
import Entity.HibernateUtil;
import Entity.Reserva;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ReservaService {
    
    public static List<Reserva> list(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Reserva");
        return query.list();
    }   
    
    public static Reserva getByToken(String token){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Reserva where tokeninvitacion=:token");
            query.setParameter("token", token);
            Reserva reservae = (Reserva) query.list().get(0);
            session.close();
            return reservae;
        } catch(Exception e){
            System.err.println(e);
            return null;
        }
        
    }
    
    public static List<Reserva> listByFechaCancha(Date fecha, int canchaId){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Reserva where fecha=:fecha and cancha_id=:cancha");
            query.setParameter("fecha", fecha);
            query.setParameter("cancha", canchaId);
            return query.list();
        } catch(Exception e){
            System.err.println(e);
            return null;
        }
        
    }
    
    public static void add(Reserva reserva){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(reserva);
        tx.commit();
        session.close();
    }
}
