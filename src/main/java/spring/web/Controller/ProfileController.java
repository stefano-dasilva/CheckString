package spring.web.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import Config.FactoryUtil;
import Config.MD5;
import Model.Corrispondenza;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.Interface.UtenteService;
import spring.web.vo.UserRegister;
import spring.web.vo.UserLogin;

import java.security.NoSuchAlgorithmException;


@Controller
public class ProfileController {

    @Autowired
    private UtenteService utenteService;


    @GetMapping("/show_profile")
    public String showProfile(HttpServletRequest request, Model m) {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username == null ){
            return "/login";
        }

        Utente u = utenteService.findByUsername(username);
        System.out.println("show_prorfile " + u.getUsername());
        System.out.println("show_prorfile " + u.getNome());
        System.out.println("show_prorfile " + u.getCognome());
        System.out.println("show_prorfile " + u.getDataNascita());
        System.out.println("show_prorfile " + u.getNazione());

        m.addAttribute("username",u.getUsername());
        m.addAttribute("name",u.getNome());
        m.addAttribute("cognome",u.getCognome());
        m.addAttribute("nazione",u.getNazione());
        m.addAttribute("data_nascita",u.getDataNascita());





        return "profile";
    }



}


