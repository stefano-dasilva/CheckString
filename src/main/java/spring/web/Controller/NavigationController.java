package spring.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Base64;
import Model.Utente;


@Controller
public class NavigationController {

    @GetMapping("/show_home")
    public String showHome() {


        return "home";
    }

    @GetMapping("/show_games")
    public String showGamesSelection() {


        return "gamesselection";
    }

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


    @GetMapping("/show_giocobandiere")
        public String showGiocoBandiere() {
            return "giocobandiere";
        }



}




