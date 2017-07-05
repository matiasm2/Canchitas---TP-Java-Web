/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HibernateUtil;
import Entity.Usuario;
import java.lang.Exception;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pow
 */
public class LoginService {
    
    
    public static boolean isLogged(String token){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query qUser = session.createQuery("from Usuario where token=:token");
        qUser.setParameter("token", token);
        try{
            Usuario user = (Usuario) qUser.list().get(0);
            session.close();
            if (user.getToken().equals(token)){
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
    
    public static boolean isAdmin(String token){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query qUser = session.createQuery("from Usuario where token=:token");
        qUser.setParameter("token", token);
        try{
            Usuario user = (Usuario) qUser.list().get(0);
            if (user.getToken().equals(token)){
                if (user.getRol().getRol().equals("administrador")){
                    session.close();
                    return true;
                }
            } else {
                session.close();
                return false;
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
    
}
