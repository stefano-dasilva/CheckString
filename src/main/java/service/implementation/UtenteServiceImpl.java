package service.implementation;

import Dao.Interface.UtenteDao;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.UtenteService;

public class UtenteServiceImpl implements UtenteService {

    @Autowired
    UtenteDao utenteDao;

    public UtenteServiceImpl() {}



    @Override
    public Utente inserisciUtente(Utente utente) {
       if (utente!=null){
           System.out.println("sono dentro dao utente");
           Utente u = utenteDao.findByUsername(utente.getUsername());
           if(u == null) {
               Utente usernuovo = utenteDao.create(utente);
               return usernuovo;
           }
       }
       return null;
    }

    @Override
    public Utente rimuoviUtente(Utente utente) {
        if (utente!=null){
            if(utenteDao.findByUsername(utente.getUsername())!=null){
                utenteDao.delete(utente);
            }

        }
        return utente;
    }

    @Override
    public Utente cambiaPassword(Utente utente, String password) {
        if (utente!=null && password!=null) {
            utenteDao.cambiaPassword(utente, password);
            utente.setPassword(password);
        }
        return utente;
    }


}
