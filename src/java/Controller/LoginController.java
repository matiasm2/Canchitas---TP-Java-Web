package Controller;

import Entity.HibernateUtil;
import Entity.Usuario;
import Service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pow
 */
@Controller
public class LoginController {
    
    @RequestMapping(value="login.htm", method=RequestMethod.GET )
    public ModelAndView loginPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
    
    @RequestMapping(value="login.htm", method=RequestMethod.POST )
    public ModelAndView login(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Usuario user = UsuarioService.getByEmail(request.getParameter("email"));
            String hash = user.getContrasena();
            if (BCrypt.checkpw(request.getParameter("password"), hash)){
            String token = BCrypt.hashpw(String.valueOf(System.currentTimeMillis()), BCrypt.gensalt());
            user.setToken(token);
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
            if (user.getRol().getRol().equals("administrador")){
                return new ModelAndView("redirect:/admin/crearadmin.htm", "usuario", user.getToken());
            } else {
                return new ModelAndView("redirect:/bienvenido.htm", "usuario", user.getToken());
            }
            
            } else {
                mav.setViewName("login");
            }
        } catch (Exception e){
            System.err.println(e);
            mav.setViewName("login");
        }
        session.close();
        return mav;
    }
    
    @RequestMapping(value = "salir", method = RequestMethod.POST)
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("pruebas");
        Usuario user = UsuarioService.getByToken(request.getParameter("casa"));
        user.setToken(null);
        UsuarioService.update(user);
        mav.addObject("nombre", "Usuario deslogueado");
        return mav;
    }
}
