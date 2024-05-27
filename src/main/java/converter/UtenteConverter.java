package converter;

import Model.Utente;
import org.springframework.beans.BeanUtils;
import spring.web.dto.UtenteClassifica;
import spring.web.vo.SalvaRegister;
import spring.web.vo.UserRegister;

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

    public static UtenteClassifica convert (Utente utente, String tipoGioco){
        UtenteClassifica utenteClassifica = new UtenteClassifica();

       utenteClassifica.setNome(utente.getNome());
       utenteClassifica.setCognome(utente.getCognome());
       utenteClassifica.setUsername(utente.getUsername());
       if(utente.getImmagine()!=null){
           utenteClassifica.setFoto(Base64.getEncoder().encodeToString(utente.getImmagine()));
       }
       else{
           utenteClassifica.setFoto("src/main/webapp/resources/profile.jpg");
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
