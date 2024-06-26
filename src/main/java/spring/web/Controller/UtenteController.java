package spring.web.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import service.Interface.StandardService;
import spring.web.dto.UtenteClassifica;
import spring.web.vo.Filter.ClassificaFilter;
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
        Utente utente =  (Utente ) session.getAttribute("utente");




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
            System.out.println("C'è stato un errore");
            return "redirect:/show_profile";
        }

        Utente utente = UtenteConverter.convert(salvaRegister);
        Utente sessionUser = (Utente) session.getAttribute("utente");


        if(sessionUser != null) {
            session.setAttribute("utente", utenteService.updateDati(sessionUser, utente));
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




    @PostMapping("/classifica")

    public String Classifica(@ModelAttribute("classificafilter") @Valid ClassificaFilter classificaFilter,BindingResult bindingResult, Model m, HttpSession session) throws IOException {

        List<Standard> standards = standardService.getAll();
        List<String> values = new ArrayList<>();
        System.out.println(classificaFilter.getMinimo());
        System.out.println(classificaFilter.getMassimo());
        if(classificaFilter.getCategoriaGioco() == null){
            classificaFilter.setCategoriaGioco("Tutte");
        }
        System.out.println(classificaFilter.getCategoriaGioco());
        System.out.println(classificaFilter.getNazione());

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


