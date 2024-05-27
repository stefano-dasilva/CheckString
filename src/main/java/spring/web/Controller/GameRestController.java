package spring.web.Controller;

import Model.Standard;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.Interface.CheckStringService;
import service.Interface.StandardService;
import service.Interface.UtenteService;

import javax.servlet.http.HttpSession;

@RestController
public class GameRestController {

    @Autowired
    StandardService standardService;

    @Autowired
    CheckStringService checkStringService;

    @Autowired
    UtenteService utenteService;



    @RequestMapping(
            path={"/randomcountry"},
            method= {RequestMethod.GET},
            produces  = {MediaType.APPLICATION_JSON_VALUE}
    )
    private String getBandiera(){
        Standard standard = standardService.getRandom();
        String code = standard.getCode();
        String value = standard.getValue();

        return String.format("{\"code\":\"%s\", \"value\":\"%s\"}", code, value);

    }


    @RequestMapping(
            path={"randomcountry2"},
            method = {RequestMethod.GET},
            produces ={MediaType.APPLICATION_JSON_VALUE}
    )
    private  String getBandiera2(){

        Standard standard1 = standardService.getRandom();
        String code1 = standard1.getCode();
        String value1 = standard1.getValue();

        Standard standard2 = standardService.getRandom();
        String code2 = standard2.getCode();
        String value2 = standard2.getValue();

        Standard standard3 = standardService.getRandom();
        String code3 = standard3.getCode();
        String value3 = standard3.getValue();

        Standard standard4 = standardService.getRandom();
        String code4 = standard4.getCode();
        String value4 = standard4.getValue();

        return String.format("{\"code1\":\"%s\", \"value1\":\"%s\", " +
                        "\"code2\":\"%s\", \"value2\":\"%s\", " +
                        "\"code3\":\"%s\", \"value3\":\"%s\", " +
                        "\"code4\":\"%s\", \"value4\":\"%s\"}",
                code1, value1, code2, value2, code3, value3, code4, value4);

    }

    @RequestMapping(
            path={"randomcountry3"},
            method = {RequestMethod.GET},
            produces ={MediaType.APPLICATION_JSON_VALUE}
    )
    private  String randomcountry3(){

        Standard standard1 = standardService.getRandom();
        String code1 = standard1.getCode();
        String value1 = standard1.getValue();

        Standard standard2 = standardService.getRandom();
        String code2 = standard2.getCode();
        String value2 = standard2.getValue();



        return String.format("{\"standard1\": {\"code\": \"%s\", \"value\": \"%s\"}, " +
                        "\"standard2\": {\"code\": \"%s\", \"value\": \"%s\"}}",
                code1, value1, code2, value2);


    }




    @RequestMapping(
            path={"/checkstring"},
            method= {RequestMethod.GET},
            produces  = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String getCheckString(@RequestParam("input") String input){

        String  inputStandard = checkStringService.check(input);

        return String.format("{\"inputstandard\":\"%s\"}", inputStandard);

    }

    @RequestMapping(
            path={"/aumentapunti"},
            method= {RequestMethod.GET},
            produces  = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String aumentaPunti(HttpSession session){


        if(session.getAttribute("punteggio") == null){
            session.setAttribute("punteggio",1);
        }
        else{
            System.out.println("aumentapuntielse");
            session.setAttribute("punteggio", (Integer) session.getAttribute("punteggio") + 1 );
        }

        return String.format("{\"punteggio\":\"%s\"}", session.getAttribute("punteggio"));

    }

    @RequestMapping(
            path={"/finiscigioco"},
            method= {RequestMethod.GET},
            produces  = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String finisciGioco(@RequestParam("gioco") String gioco, HttpSession session){

        Utente utente =(Utente) session.getAttribute("utente");
        boolean nuovo_record = false;

        System.out.println("il gioco è finito");
        int punteggio;
        if(session.getAttribute("punteggio") != null){
            punteggio = (Integer ) session.getAttribute("punteggio");
            if(gioco.equals("giocoBandiere")){
                nuovo_record = utenteService.setRecordBandiere(utente,punteggio);
            }
            else if(gioco.equals("giocoCapitali")){
                nuovo_record = utenteService.setRecordCapitali(utente,punteggio);
            }
            else if(gioco.equals("giocoPopolazione")){
                nuovo_record = utenteService.setRecordPopolazione(utente,punteggio);
            }
        }
        else{
            punteggio = 0;
        }
        System.out.println(punteggio);

        return String.format("{\"punteggio\":\"%s\", \"nuovo_record\":\"%s\"}", punteggio, nuovo_record);
    }

}
