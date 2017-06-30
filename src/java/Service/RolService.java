/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HibernateUtil;
import Entity.Rol;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

public class RolService {
    
    
    public static Rol getByName(String rol){
        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from Rol where rol=:rol");
            query.setParameter("rol", rol);
            Rol role = (Rol) query.list().get(0);
            session.close();
            return role;
        } catch(Exception e){
            System.err.println(e);
            return null;
        }
        
    }
    
    public static void add(Rol rol){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(rol);
        tx.commit();
        session.close();
    }
}
