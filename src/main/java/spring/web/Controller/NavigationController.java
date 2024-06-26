package spring.web.Controller;

import Config.FactoryUtil;
import converter.UtenteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import Model.Standard;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import Model.Utente;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;
import service.Interface.StandardService;
import service.Interface.UtenteService;
import spring.web.vo.Filter.ClassificaFilter;
import spring.web.vo.SalvaRegister;
import spring.web.vo.UserRegister;


@Controller
public class NavigationController {

    File file=new File("C:\\Users\\SAEEDH\\Desktop\\CheckString\\CheckString\\src\\main\\webapp\\resources\\profile.jpg");
    byte[] defaultBytes= Files.readAllBytes(file.toPath());

    @Autowired
    private RouterFunctionMapping routerFunctionMapping;

    {
        try {
            defaultBytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Autowired
    private UtenteService utenteService;

    public NavigationController() throws IOException {
    }

    @GetMapping("/rimuoviImg")
    public String rimuoviImag(HttpSession session) {
        Utente u = (Utente) session.getAttribute("utente");
        if (u != null) {
            try {
                utenteService.rimuoviImg(u, defaultBytes);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return "redirect:/show_profile"; // Redirect to profile page after removing image
    }


    @GetMapping("/show_home")
    public String showHome() {


        return "home";
    }



    @GetMapping("/show_games")
    public String showGamesSelection() {


        return "gamesselection";
    }


    @GetMapping("/show_profile")
    public String showProfile(HttpSession session, Model m) throws IOException {


        Utente u = (Utente) session.getAttribute("utente");
        System.out.println(u.getUsername() + u.getNome() + u.getCognome());
        SalvaRegister salvaRegister = UtenteConverter.convert(u);
        m.addAttribute("salvaRegister", salvaRegister);
        System.out.println(u.getUsername() + u.getNome() + u.getCognome());
        if(u.getImmagine() != null){
            System.out.println("utente ha già un immagine");
            String base64Image = Base64.getEncoder().encodeToString(u.getImmagine());
            m.addAttribute("immagine", base64Image);
        }else {
            System.out.println("utente NON ha un immagine");
            String base64Image = Base64.getEncoder().encodeToString(defaultBytes);
            m.addAttribute("immagine", base64Image);
        }

        return "profile";
    }



    @GetMapping("/show_giocobandiere")
        public String showGiocoBandiere(HttpSession session) {
        session.setAttribute("skips",3);

        if(session.getAttribute("punteggio")!= null){
            session.setAttribute("punteggio",0);
        }
        else{
            session.setAttribute("punteggio",0);
        }

        return "giocobandiere";
        }


    @GetMapping("/show_giocoCapitali")
    public String showGiocoCapitali(HttpSession session) {

        if(session.getAttribute("punteggio")!= null){
            session.setAttribute("punteggio",0);
        }
        else{
            session.setAttribute("punteggio",0);
        }
        return "capitali";
    }

    @GetMapping("/show_giocopopolazione")
    public String showGiocoPopolazione(HttpSession session) {
        if(session.getAttribute("punteggio")!= null){
            session.setAttribute("punteggio",0);
        }
        else{
            session.setAttribute("punteggio",0);
        }
        return "giocopopolazioni";
    }




}






