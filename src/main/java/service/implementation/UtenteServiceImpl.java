package service.implementation;

import Config.MD5;
import Dao.Interface.UtenteDao;
import Model.Corrispondenza;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import service.CheckStringService;
import service.Interface.UtenteService;

import java.security.NoSuchAlgorithmException;

public class UtenteServiceImpl implements UtenteService {



    @Autowired
    UtenteDao utenteDao;
    @Autowired
    CheckStringService checkStringService;

    public UtenteServiceImpl() {}



    @Override
    public Utente inserisciUtente(Utente utente) throws NoSuchAlgorithmException {
       if (utente!=null){
           System.out.println("sono dentro dao utente");
           Utente u = utenteDao.findByUsername(utente.getUsername());
           if(u == null) {
               MD5 md5 = new MD5(utente.getPassword());
               utente.setPassword(md5.hash());
               Corrispondenza corrispondenza = checkStringService.buildChain().check(utente.getNazione());
               if(corrispondenza!= null){
                   utente.setNazione(corrispondenza.getStandard().getValue());
               }
               else{
                   utente.setNazione("non trovata");
               }
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

    @Override
    public Utente findByUsername(String username) {
        return utenteDao.findByUsername(username);
    }




}
