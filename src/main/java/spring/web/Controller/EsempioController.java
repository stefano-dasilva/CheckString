package spring.web.Controller;

import javax.jws.WebParam;
import javax.validation.Valid;


import Config.FactoryUtil;
import Model.Corrispondenza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.web.vo.UserForm;


@Controller
public class EsempioController {


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

        return "Paese non riconosciuto";
    }





}


