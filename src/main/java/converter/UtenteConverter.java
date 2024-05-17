package converter;

import Model.Utente;
import org.springframework.beans.BeanUtils;
import spring.web.vo.UserRegister;

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
}
