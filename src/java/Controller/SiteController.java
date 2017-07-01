/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Usuario;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pow
 */
public class SiteController {
    
    @RequestMapping(value="bienvenido", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("site/bienvenido");
        mav.addObject("usuario", request.getParameter("usuario"));
        
        return mav;
    }
    
}
