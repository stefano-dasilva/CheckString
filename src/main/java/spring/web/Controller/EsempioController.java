package spring.web.Controller;

import javax.jws.WebParam;
import javax.validation.Valid;


import Config.FactoryUtil;
import Model.Corrispondenza;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.Interface.UtenteService;
import spring.web.vo.UserForm;
import spring.web.vo.UserLogin;


@Controller
public class EsempioController {

    @Autowired
    private UtenteService utenteService;


    @GetMapping("/form_register")
    public String showRegister(Model m, @ModelAttribute("userform") UserForm userForm) {

        m.addAttribute("userform",userForm);
        return "register";
    }

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }



    @PostMapping("/register")
    @ResponseBody
    public String Register(@ModelAttribute("userform") @Valid UserForm userform, BindingResult bindingResult, Model model) {
        FactoryUtil factoryUtil = FactoryUtil.getIstanza();
      //  Corrispondenza corrispondenza = factoryUtil.getCheckStringService().buildChain().check(nazione);
        System.out.println("form:" + userform);
        System.out.println("br:" + bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }
        else
        {
            Utente utente = new Utente();
            utente.setNome(userform.getNome());
            utente.setCognome(userform.getCognome());
            utente.setDataNascita(userform.getDataNascita());
            utente.setUsername(userform.getUsername());
            utente.setPassword(userform.getPassword());
             Corrispondenza corrispondenza = factoryUtil.getCheckStringService().buildChain().check(userform.getNazione());
            if(corrispondenza!= null){
                utente.setNazione(corrispondenza.getStandard().getValue());
            }
            else{
                utente.setNazione("non trovata");
            }


            if( utenteService.inserisciUtente(utente)!= null){
                return "Salve " + utente.getUsername() + " da " + utente.getNazione();
            }
            else
                return "L'utente già esiste ";

        }
    }

    @PostMapping("/login")
    @ResponseBody
    public String Login(@ModelAttribute("userlogin") @Valid UserLogin userLogin, BindingResult bindingResult, Model model) {
        System.out.println("login:" + userLogin);
        System.out.println("br:" + bindingResult);

        if(bindingResult.hasErrors()) {
            return "login";

        }else {

            return "Login Effettuato";
        }
    }







}


