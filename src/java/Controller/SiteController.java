/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Cancha;
import Service.CanchaService;
import Service.HoraService;
import Service.LoginService;
import Entity.Hora;
import Entity.Invitacion;
import Entity.Reserva;
import Entity.Usuario;
import Service.InvitacionService;
import Service.MailSendService;
import Service.ReservaService;
import Service.UsuarioService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.mindrot.jbcrypt.BCrypt;
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
        if (LoginService.isLogged(request.getParameter("usuario"))){
            ModelAndView mav = new ModelAndView("site/bienvenido");
            mav.addObject("usuario", request.getParameter("usuario"));

            return mav;
        } else {
            return new ModelAndView("redirect:/login.htm");
        }
    }
    
    @RequestMapping(value = "agregar", method = RequestMethod.GET)
    public ModelAndView agregarReserva(HttpServletRequest request){
        if (LoginService.isLogged(request.getParameter("usuario"))){
            ModelAndView mav = new ModelAndView("site/crearreserva");
            mav.addObject("canchas", CanchaService.list());
            mav.addObject("usuario", request.getParameter("usuario"));
            return mav;
        } else {
            return new ModelAndView("redirect:/login.htm");
        }
        
    }
    
    @RequestMapping(value = "agregar", method = RequestMethod.POST)
    public ModelAndView agregarReservaPOST(HttpServletRequest request) throws ParseException{
        if (LoginService.isLogged(request.getParameter("usuario"))){
            ModelAndView mav = new ModelAndView("site/horario");
            mav.addObject("usuario", request.getParameter("usuario"));
            mav.addObject("nombrecancha", request.getParameter("nombrecancha"));
            mav.addObject("fecha", request.getParameter("fecha"));
            Cancha cancha = CanchaService.getByName(request.getParameter("nombrecancha"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaparseada = format.parse(request.getParameter("fecha"));
            List<Hora> horasTotal = HoraService.list();
            List<Hora> horasABorrar = new ArrayList<Hora>();
            List<Reserva> reservas = ReservaService.listByFechaCancha(fechaparseada, cancha.getCanchaId());
            if (reservas!=null){
                for (Reserva reserva : reservas){
                    for (Hora hora : horasTotal){
                        if (hora.getHora()==reserva.getHora().getHora()){
                            horasABorrar.add(hora);
                        }
                    }
                }
                horasTotal.removeAll(horasABorrar);
            }
            
            
            mav.addObject("lista", horasTotal);

            return mav;
        } else {
            return new ModelAndView("redirect:/login.htm");
        }
    }
    
    @RequestMapping(value = "horario", method = RequestMethod.POST)
    public ModelAndView listarHorariosPOST(HttpServletRequest request) throws ParseException{
        if (LoginService.isLogged(request.getParameter("usuario"))){
            ModelAndView mav = new ModelAndView("pruebas");
            mav.addObject("nombre", request.getParameter("Reserva agregada"));
            mav.addObject("usuario", request.getParameter("usuario"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaparseada = format.parse(request.getParameter("fecha"));
            Cancha cancha = CanchaService.getByName(request.getParameter("nombrecancha"));
            Hora hora = HoraService.getByHora(Integer.valueOf(request.getParameter("hora")));
            Reserva reserva = new Reserva();
            Usuario usuario = UsuarioService.getByToken(request.getParameter("usuario"));
            reserva.setCancha(cancha);
            reserva.setFecha(fechaparseada);
            reserva.setHora(hora);
            reserva.setTokeninvitacion(BCrypt.hashpw(String.valueOf(System.currentTimeMillis()), BCrypt.gensalt()));
            reserva.setUsuario(usuario);
            ReservaService.add(reserva);
            MailSendService.sendMailTo(usuario.getEmail(), "Reserva agregada", 
                    "Reserva agregada, su url para invicationes es localhost:8080/tpf/invitacion.htm?token="+reserva.getTokeninvitacion());
            
            return mav;
        } else {
            return new ModelAndView("redirect:/login.htm");
        }
    }
    
    @RequestMapping(value = "invitacion", method = RequestMethod.GET)
    public ModelAndView aceptarInvitacion(HttpServletRequest request){
        if (LoginService.isLogged(request.getParameter("usuario"))){
            ModelAndView mav = new ModelAndView("site/invitacion");
            mav.addObject("usuario", request.getParameter("usuario"));
            return mav;
        } else {
            return new ModelAndView("redirect:/login.htm", "tokeninvitacion", request.getParameter("token"));
        }
        
    }
    
    @RequestMapping(value = "invitacion", method = RequestMethod.POST)
    public ModelAndView aceptarInvitacionPOST(HttpServletRequest request) throws ParseException{
        if (LoginService.isLogged(request.getParameter("usuario"))){
            ModelAndView mav = new ModelAndView("redirect:/bienvenido.htm","usuario",request.getParameter("usuario"));
            if (request.getParameter("respuesta").equals("si")){
                String token = request.getParameter("tokeninvitacion");
                Usuario usuario = UsuarioService.getByToken(request.getParameter("usuario"));
                Invitacion invitacion = new Invitacion();
                invitacion.setReserva(ReservaService.getByToken(token));
                invitacion.setUsuario(usuario);
                InvitacionService.add(invitacion);
                return mav;
            } else {
                return mav;
            }
        } else {
            return new ModelAndView("redirect:/login.htm");
        }
    }
}
