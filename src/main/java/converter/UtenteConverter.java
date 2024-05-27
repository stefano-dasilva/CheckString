package converter;

import Model.Utente;
import org.springframework.beans.BeanUtils;
import spring.web.dto.UtenteClassifica;
import spring.web.vo.SalvaRegister;
import spring.web.vo.UserRegister;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class UtenteConverter {

    public static Utente convert (UserRegister userRegister){
        Utente utente = new Utente();
        BeanUtils.copyProperties(userRegister, utente);
      /*  utente.setNome(userRegister.getNome());
        utente.setCognome(userRegister.getCognome());
        utente.setDataNascita(userRegister.getDataNascita());
        utente.setUsername(userRegister.getUsername());
        utente.setPassword(userRegister.getPassword());
        utente.setNazione(userRegister.getNazione()); */
        return utente;


    }

    public static Utente convert (SalvaRegister salvaRegister){
        Utente utente = new Utente();
        BeanUtils.copyProperties(salvaRegister, utente);
      /*  utente.setNome(userRegister.getNome());
        utente.setCognome(userRegister.getCognome());
        utente.setDataNascita(userRegister.getDataNascita());
        utente.setUsername(userRegister.getUsername());
        utente.setPassword(userRegister.getPassword());
        utente.setNazione(userRegister.getNazione()); */
        return utente;


    }

    public static SalvaRegister convert (Utente u){
        SalvaRegister salvaRegister = new SalvaRegister();
        salvaRegister.setUsername(u.getUsername());
        salvaRegister.setCognome(u.getCognome());
        salvaRegister.setNome(u.getNome());
        salvaRegister.setDataNascita(u.getDataNascita());
        salvaRegister.setNazione(u.getNazione());
        return salvaRegister;

    }

    public static UtenteClassifica convert (Utente utente, String tipoGioco) throws IOException {
        UtenteClassifica utenteClassifica = new UtenteClassifica();

       utenteClassifica.setNome(utente.getNome());
       utenteClassifica.setCognome(utente.getCognome());
       utenteClassifica.setUsername(utente.getUsername());
       if(utente.getImmagine()!=null){
           utenteClassifica.setFoto(Base64.getEncoder().encodeToString(utente.getImmagine()));
       }
       else{
           File file=new File("C:\\Users\\DASILVAS\\Desktop\\progetti\\CheckString\\src\\main\\webapp\\resources\\profile.jpg");
           byte[] defaultBytes= Files.readAllBytes(file.toPath());
           utenteClassifica.setFoto(Base64.getEncoder().encodeToString(defaultBytes));
       }
       if(tipoGioco.equals("giocoBandiere")){
           utenteClassifica.setPunteggio(utente.getRecordBandiere());
       }
        else if(tipoGioco.equals("giocoCapitali")){
           utenteClassifica.setPunteggio(utente.getRecordCapitali());

        }
        else if(tipoGioco.equals("giocoPopolazione")){
            utenteClassifica.setPunteggio(utente.getRecordPopolazioni());

        }
        else {
            utenteClassifica.setPunteggio(utente.getRecordBandiere() + utente.getRecordCapitali() + utente.getRecordPopolazioni());
       }

        return utenteClassifica;


    }
}
