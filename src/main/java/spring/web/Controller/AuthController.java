package spring.web.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import Config.FactoryUtil;
import Config.MD5;
import Model.Corrispondenza;
import Model.Utente;
import converter.UtenteConverter;
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
public class AuthController {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private HttpSession httpSession;


    @GetMapping("/form_register")
    public String showRegister(Model m) {

        m.addAttribute("userregister", new UserRegister());
        return "register";
    }



    @PostMapping("/register")
    public String Register(@ModelAttribute("userregister") @Valid UserRegister userRegister, BindingResult bindingResult, Model model, HttpSession session) throws NoSuchAlgorithmException {
        FactoryUtil factoryUtil = FactoryUtil.getIstanza();
        System.out.println("form:" + userRegister);
        System.out.println("br:" + bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }
        else
        { Utente utente = UtenteConverter.convert(userRegister);


            if( utenteService.inserisciUtente(utente)!= null){
                session.setAttribute("username", utente.getUsername());
                return "redirect:/show_profile";
            }
            else
                return "register";

        }
    }

    @GetMapping("/")
    public String showLogin(Model m) {
        m.addAttribute("userlogin",new UserLogin());
        return "login";
    }

    @PostMapping("/login")
    public String Login(@ModelAttribute("userlogin") @Valid UserLogin userLogin, BindingResult bindingResult, Model model, HttpServletRequest request) throws NoSuchAlgorithmException {
        System.out.println("user:" + userLogin.getUsername());
        System.out.println("password:" + userLogin.getPassword());

        System.out.println("br:" + bindingResult);

        if(bindingResult.hasErrors()) {
            return "login";

        }else {

            Utente u = utenteService.findByUsername(userLogin.getUsername());
            if(u == null){
                model.addAttribute("errorUsername", "Utente non esiste");
                return "login";
            }
            MD5 md5 = new MD5(userLogin.getPassword());
            System.out.println("hashing "  + md5.hash());
            System.out.println("password in db " + u.getPassword());

            if(!u.getPassword().equalsIgnoreCase(md5.hash())){
                model.addAttribute("errorPass", "Password sbagliata");
                return "login";
            }


            HttpSession session = request.getSession();
            session.setAttribute("username",u.getUsername());
            return "redirect:/show_profile";
        }
    }


    @GetMapping("/logout")
    public String Logout(HttpServletRequest request, Model m) {
       request.getSession().invalidate();
       System.out.println("Sessione chiusa");
       m.addAttribute("userlogin", new UserLogin());
       return "login";
    }




//
}


