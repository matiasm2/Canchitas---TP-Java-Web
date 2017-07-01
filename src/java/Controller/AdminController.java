/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Cancha;
import Entity.Tamanocancha;
import Entity.Usuario;
import Service.CanchaService;
import Service.RolService;
import Service.TamanoCanchaService;
import Service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    
    @RequestMapping(value="admin/crearadmin", method = RequestMethod.GET)
    public ModelAndView crearAdmin(){
        return new ModelAndView("admin/crearadmin");
        
    }@RequestMapping(value="admin/crearadmin", method = RequestMethod.POST)
    public ModelAndView crearAdminPOST(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        String hash1 = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
        mav.addObject("nombre", request.getParameter("nombre"));
        mav.addObject("email", request.getParameter("email"));
        mav.addObject("password", request.getParameter("password"));
        mav.addObject("hash1", hash1);
        Usuario user = new Usuario();
        user.setNombre(request.getParameter("nombre"));
        user.setEmail(request.getParameter("email"));
        user.setContrasena(hash1);
        UsuarioService.add(user, RolService.getByName("administrador"));
        mav.setViewName("pruebas");
        return mav;
    }
    
    @RequestMapping(value="admin/creartamanocancha", method = RequestMethod.GET)
    public ModelAndView crearTamanoCancha(){
        return new ModelAndView("admin/creartamanocancha");
        
    }
    
    @RequestMapping(value="admin/creartamanocancha", method = RequestMethod.POST)
    public ModelAndView crearTamanoCanchaPOST(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.addObject("nombre", request.getParameter("tamanocancha"));
        mav.addObject("email", request.getParameter("precio"));
        Tamanocancha tamanocancha = new Tamanocancha();
        tamanocancha.setTamanocancha(request.getParameter("tamanocancha"));
        tamanocancha.setPrecio(Integer.valueOf(request.getParameter("precio")));
        TamanoCanchaService.add(tamanocancha);
        mav.setViewName("pruebas");
        return mav;
    }
    
    @RequestMapping(value="admin/crearcancha", method = RequestMethod.GET)
    public ModelAndView crearCancha(){
        ModelAndView mav = new ModelAndView("admin/crearcancha");
        mav.addObject("tamanos", TamanoCanchaService.list());
        return mav;
        
    }
    
    @RequestMapping(value="admin/crearcancha", method = RequestMethod.POST)
    public ModelAndView crearCanchaPOST(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("pruebas");
        mav.addObject("nombre", request.getParameter("tamanocancha"));
        mav.addObject("email", request.getParameter("nombre"));
        Cancha cancha = new Cancha();
        cancha.setNombre(request.getParameter("nombre"));
        cancha.setTamanocancha(TamanoCanchaService.getByName(request.getParameter("tamanocancha")));
        CanchaService.add(cancha);
        return mav;
    }
}
