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


    @GetMapping("/show_profile")
    public String showProfile(HttpSession session, Model m) {


        Utente u = (Utente) session.getAttribute("user");
        System.out.println(u.getUsername() + u.getNome() + u.getCognome());

        m.addAttribute("username",u.getUsername());
        m.addAttribute("name",u.getNome());
        m.addAttribute("cognome",u.getCognome());
        m.addAttribute("nazione",u.getNazione());
        m.addAttribute("data_nascita",u.getDataNascita());
        if(u.getImmagine() != null){
        String base64Image = Base64.getEncoder().encodeToString(u.getImmagine());

        m.addAttribute("immagine", base64Image);
        }




        return "profile";
    }

    @GetMapping("/show_home")
    public String showHome() {


        return "home";
    }

    @GetMapping("/show_games")
    public String showGames() {


        return "gamesselection";
    }

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


