package spring.web.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import Config.FactoryUtil;
import Config.MD5;
import Model.Corrispondenza;
import Model.Utente;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.Interface.UtenteService;
import spring.web.vo.UserRegister;
import spring.web.vo.UserLogin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;


@Controller
public class ProfileController {

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
    public String upload(@RequestParam("img") CommonsMultipartFile img, HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        Utente utente = utenteService.findByUsername(username);

          if(utente != null && !img.isEmpty()) {
            String name = img.getOriginalFilename();
            byte[] bytes = img.getBytes();
            String path = request.getSession().getServletContext().getRealPath("/") + "resources" + File.separator + "img" +
                    File.separator + name;
            System.out.println(name + path);


            try {
                FileOutputStream immagine = new FileOutputStream(new File(path));
                immagine.write(bytes);
                immagine.close();
                System.out.println("immagine caricata");
                utente.setImmagine(bytes);

            } catch (Exception e) {
                e.printStackTrace();
            }


            model.addAttribute("imagine", utente.getImmagine());
            System.out.println("immaggine " + utente.getImmagine());
        }

         return "profile";


    }





}


