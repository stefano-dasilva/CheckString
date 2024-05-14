package spring.web.Controller;

import javax.jws.WebParam;


import Config.FactoryUtil;
import Model.Corrispondenza;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class EsempioController {


    @GetMapping("/form_register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }



    @PostMapping("/submit")
    @ResponseBody
    public String checkString(@WebParam(name = "nome") String nome,
                            @WebParam(name = "cognome") String cognome,
                            @WebParam(name = "nazione") String nazione,
                            @WebParam(name = "password") String password,
                              @WebParam(name="nascita")String nascita  ) {
        FactoryUtil factoryUtil = FactoryUtil.getIstanza();
        Corrispondenza corrispondenza = factoryUtil.getCheckStringService().buildChain().check(nazione);
        if(corrispondenza != null){
        return  "Benvenuto " + nome + " " +  cognome  + " da " + corrispondenza.getStandard().getValue() + " nascita " + nascita;
        }
        else
            return "Paese non riconosciuto";
    }





}


