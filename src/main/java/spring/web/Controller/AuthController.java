package spring.web.Controller;

import javax.validation.Valid;


import Config.FactoryUtil;
import Config.MD5;
import Model.Corrispondenza;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/form_register")
    public String showRegister(Model m, @ModelAttribute("userregister") UserRegister userRegister) {

        m.addAttribute("userregister", userRegister);
        return "register";
    }



    @PostMapping("/register")
    public String Register(@ModelAttribute("userregister") @Valid UserRegister userRegister, BindingResult bindingResult, Model model) throws NoSuchAlgorithmException {
        FactoryUtil factoryUtil = FactoryUtil.getIstanza();
        System.out.println("form:" + userRegister);
        System.out.println("br:" + bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }
        else
        {
            Utente utente = new Utente();
            utente.setNome(userRegister.getNome());
            utente.setCognome(userRegister.getCognome());
            utente.setDataNascita(userRegister.getDataNascita());
            utente.setUsername(userRegister.getUsername());
            MD5 md5 = new MD5(userRegister.getPassword());
            utente.setPassword(md5.hash());
             Corrispondenza corrispondenza = factoryUtil.getCheckStringService().buildChain().check(userRegister.getNazione());
            if(corrispondenza!= null){
                utente.setNazione(corrispondenza.getStandard().getValue());
            }
            else{
                utente.setNazione("non trovata");
            }


            if( utenteService.inserisciUtente(utente)!= null){
                return "profile";
            }
            else
                return "register ";

        }
    }


    @GetMapping("/")
    public String showLogin(Model m, @ModelAttribute("userlogin") UserLogin userLogin) {
        m.addAttribute("userlogin",userLogin);
        return "login";
    }

    @PostMapping("/login")
    public String Login(@ModelAttribute("userlogin") @Valid UserLogin userLogin, BindingResult bindingResult, Model model) throws NoSuchAlgorithmException {
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

            return "profile";
        }
    }







}


