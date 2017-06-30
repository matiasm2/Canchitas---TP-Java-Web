package Controller;

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
    
    @RequestMapping(value="login", method=RequestMethod.GET)
    public ModelAndView loginPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
    
    @RequestMapping(value="login", method=RequestMethod.POST)
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}
