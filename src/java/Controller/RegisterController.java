package Controller;

import Entity.HibernateUtil;
import Entity.Rol;
import Entity.Usuario;
import Service.RolService;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author pow
 */
@Controller
public class RegisterController {
    
   
    @Autowired
    private RolService rolService;
    
    @RequestMapping(value="register.htm", method=RequestMethod.GET )
    private ModelAndView registerPage(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("register");
//        String id = request.getParameter("id");
//        mav.addObject("id",id);
//        return mav;
        return new ModelAndView("register");
    }
    
    @RequestMapping(value="register.htm", method=RequestMethod.POST )
    private ModelAndView register(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pruebas");
        String hash1 = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
        boolean hash2 = BCrypt.checkpw("12345", hash1);
        mav.addObject("nombre", request.getParameter("nombre"));
        mav.addObject("email", request.getParameter("email"));
        mav.addObject("password", request.getParameter("password"));
        mav.addObject("hash1", hash1);
        mav.addObject("hash2", hash2);
//        Usuario user = new Usuario();
//        user.setNombre(request.getParameter("nombre"));
//        user.setEmail(request.getParameter("email"));
//        user.setContrasena("password");
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(user);
//        tx.commit();
//        session.close();
        return mav;
    }
    
    @RequestMapping(value="roladmin.htm", method=RequestMethod.GET )
    private ModelAndView admin(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        Rol admin = new Rol();
        admin.setRol("user");
        rolService.add(admin);
        return mav;
    }
    
}
