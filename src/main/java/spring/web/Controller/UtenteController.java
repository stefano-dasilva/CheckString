package spring.web.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import Config.FactoryUtil;
import Model.Utente;


import converter.UtenteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.Interface.UtenteService;
import spring.web.vo.SalvaRegister;
import spring.web.vo.UserRegister;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;


@Controller
public class UtenteController {

    @Autowired
    private UtenteService utenteService;





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

           Utente sessionUser=utenteService.findByUsername(salvaRegister.getUsername());


           if(sessionUser != null) {
               utenteService.updateDati(sessionUser, utente);
               session.setAttribute("user", utente);
           }



        return "redirect:/show_profile";
    }






    }




















