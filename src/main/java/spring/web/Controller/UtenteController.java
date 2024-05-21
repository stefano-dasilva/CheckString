package spring.web.Controller;

import javax.servlet.http.HttpSession;

import Model.Utente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.Interface.UtenteService;

import java.util.Base64;


@Controller
public class UtenteController {

    @Autowired
    private UtenteService utenteService;




    @PostMapping("/upload")
    public String upload(@RequestParam("img") CommonsMultipartFile img, HttpSession session, Model model) {



        Utente utente =  (Utente ) session.getAttribute("user");

          if(utente != null && !img.isEmpty()) {
            byte[] bytes = img.getBytes();

              utenteService.caricaImmagine(bytes, utente);
              System.out.println("Immagine caricata");



        }

         return "redirect:/show_profile";


    }





}


