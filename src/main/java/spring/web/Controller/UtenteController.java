package spring.web.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import Config.FactoryUtil;

import Filter.ClassificaFilter;
import Model.Utente;
import Model.Standard;


import converter.UtenteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.Interface.StandardService;
import service.Interface.UtenteService;
import spring.web.dto.UtenteClassifica;
import spring.web.vo.SalvaRegister;
import spring.web.vo.UserRegister;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Controller
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private StandardService standardService;





    @PostMapping("/upload")
    public String upload(@RequestParam("img") CommonsMultipartFile img, HttpSession session, Model model) {

        System.out.println("ciao");
        Utente utente =  (Utente ) session.getAttribute("user");




          if(utente != null && !img.isEmpty()) {
              try {
                  byte[] bytes = img.getBytes();
                  utenteService.caricaImmagine(bytes, utente);
                  System.out.println("Immagine caricata");
              } catch (Exception e) {
                  e.printStackTrace();
                  System.out.println("Errore durante il caricamento dell'immagine");
              }
          }

         return "redirect:/show_profile";


    }

    @RequestMapping ("/salva")
    public String salvaDati(@ModelAttribute("salvaRegister") @Valid SalvaRegister salvaRegister, BindingResult bindingResult, Model model, HttpSession session) {
        System.out.println("ciao pippo");
        if (bindingResult.hasErrors()) {
            return "profile";
        }

        Utente utente = UtenteConverter.convert(salvaRegister);

        System.out.println(utente.getDataNascita());

        Utente sessionUser= (Utente) session.getAttribute("user");



        if(sessionUser != null) {
            utenteService.updateDati(sessionUser, utente);
            session.setAttribute("user", utente);
        }



        return "redirect:/show_profile";
    }




    @GetMapping("/show_classifica")
    public String showClassifica(Model m) {
        m.addAttribute("classificafilter", new ClassificaFilter());

        List<Standard> standards = standardService.getAll();
        List<String> values = new ArrayList<>();

        for (Standard standard : standards) {
            values.add(standard.getValue());

        }
        m.addAttribute("nazioni",values);


        return "classifica";
    }


    @PostMapping("/show_classifica")
    @ResponseBody
    public String showClassificaGenerale(@ModelAttribute("filter") ClassificaFilter filter){
        System.out.println(filter.getCategoriaGioco());
        List<Utente> utenti = utenteService.showClassifica(filter);

        for(Utente utente : utenti){
            System.out.println(utente.getUsername());
        }

        return "provaprova";
    }


    @PostMapping("/classifica")

    public String Classifica(@ModelAttribute("classificafilter") @Valid ClassificaFilter classificaFilter,BindingResult bindingResult, Model m, HttpSession session) {

        List<Standard> standards = standardService.getAll();
        List<String> values = new ArrayList<>();

        for (Standard standard : standards) {
            values.add(standard.getValue());

        }

        m.addAttribute("nazioni",values);
        if(bindingResult.hasErrors()){
            return "classifica";
        }

        List<UtenteClassifica> utenticlassifica = utenteService.showClassifica(classificaFilter);

        m.addAttribute("nazioni",values);
        m.addAttribute("utenti",utenticlassifica);
        m.addAttribute("gioco",classificaFilter.getCategoriaGioco());





        return "classifica";
    }






}


