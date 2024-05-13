package spring.web.Controller;

import javax.jws.WebParam;


import Config.FactoryUtil;
import Model.Corrispondenza;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class EsempioController {


    @GetMapping("/")
    public String showForm() {
        return "form";
    }



    @PostMapping("/submit")
    @ResponseBody
    public String checkString(@WebParam(name = "nome") String nome,
                            @WebParam(name = "cognome") String cognome,
                            @WebParam(name = "naz") String nazione,
                            @WebParam(name = "password") String password
                             /* @WebParam(name="nascita")Date nascita */) {
        FactoryUtil factoryUtil = FactoryUtil.getIstanza();
        Corrispondenza corrispondenza = factoryUtil.getCheckStringService().buildChain().check(nazione);
        if(corrispondenza != null){
        return  "Benvenuto " + nome + cognome  + " da " + corrispondenza.getStandard().getValue();
        }
        else
            return "Paese non riconosciuto";
    }





}


