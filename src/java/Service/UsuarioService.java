/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HibernateUtil;
import Entity.Rol;
import Entity.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UsuarioService {
    
    
    public static Usuario getByEmail(String email){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query qUser = session.createQuery("from Usuario where email=:email");
        qUser.setParameter("email", email);
        try{
            Usuario user = (Usuario) qUser.list().get(0);
            session.close();
            return user;
        } catch (HibernateException e){
            return null;
        }
    }
    
    public static Usuario getByToken(String token){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query qUser = session.createQuery("from Usuario where token=:token");
        qUser.setParameter("token", token);
        try{
            Usuario user = (Usuario) qUser.list().get(0);
            session.close();
            return user;
        } catch (HibernateException e){
            return null;
        }
    }
    
    public static void add(Usuario usuario){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            usuario.setRol(RolService.getByName("usuario"));
            Transaction tx = session.beginTransaction();
            session.save(usuario);
            tx.commit();
        } catch (Exception e){
            System.err.println(e);
        }
        
        session.close();
    }
    
    public static void add(Usuario usuario, Rol rol){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();usuario.setRol(rol);
        Transaction tx = session.beginTransaction();
        session.save(usuario);
        tx.commit();
        session.close();
    }
    
    public static void update(Usuario usuario){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        usuario.setRol(RolService.getByName("usuario"));
        Transaction tx = session.beginTransaction();
        session.update(usuario);
        tx.commit();
        session.close();
    }
}
