package service.implementation;

import Config.MD5;
import Dao.Interface.UtenteDao;
import converter.UtenteConverter;
import spring.web.dto.UtenteClassifica;
import spring.web.vo.Filter.ClassificaFilter;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.CheckStringService;
import service.Interface.UtenteService;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UtenteServiceImpl implements UtenteService {



    @Autowired
    UtenteDao utenteDao;
    @Autowired
    CheckStringService checkStringService;


    public UtenteServiceImpl() {}

    @Override
    public List<UtenteClassifica> showClassifica(ClassificaFilter filter) {

           List<Utente> classifica_utenti = utenteDao.getClassifica(filter);
           List<UtenteClassifica> utenteClassifica = new ArrayList<>();
           for(Utente utente : classifica_utenti){
               utenteClassifica.add(UtenteConverter.convert(utente,filter.getCategoriaGioco()));
           }
           return utenteClassifica;
    }


    @Override
    public Utente inserisciUtente(Utente utente) throws NoSuchAlgorithmException {

       if (utente!=null){
           System.out.println("sono dentro dao utente");
           Utente u = utenteDao.findByUsername(utente.getUsername());
           System.out.println("before: " + u);
           if(u == null) {
               MD5 md5 = new MD5(utente.getPassword());
               utente.setPassword(md5.hash());
               utente.setRecordPopolazioni(0);
               utente.setRecordBandiere(0);
               utente.setRecordCapitali(0);
               utente.setNazione(checkStringService.check(utente.getNazione()));
               Utente usernuovo = utenteDao.create(utente);
               System.out.println("then: " + usernuovo);
               return usernuovo;
           } else{
              System.out.println("else");
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

    @Override
    public Utente caricaImmagine(byte[] img, Utente utente) {
        utenteDao.removeImg(utente);
        if(utente != null){
            utente.setImmagine(img);
            utenteDao.update(utente);
        }
        return utente;
    }

    @Override
    public Utente rimuoviImg(Utente utente, byte[] bytes) {
        utenteDao.removeImg(utente);

        utente.setImmagine(bytes);
        utenteDao.update(utente);
        return utente;
    }

    @Override
    public Utente updateDati(Utente u, Utente u1) {
        utenteDao.updateDati(u, u1);
        return u1;
    }

    @Override
    public Utente setRecordBandiere(Utente utente, int num_bandiere) {
        if(utente.getRecordBandiere() < num_bandiere){
            utente.setRecordBandiere(num_bandiere);
            utenteDao.update(utente);
        }
        return utente;
    }

    @Override
    public Utente setRecordCapitali(Utente utente, int num_capitali) {
        if(utente.getRecordBandiere() < num_capitali){
            utente.setRecordBandiere(num_capitali);
            utenteDao.update(utente);
        }
        return utente;
    }

    @Override
    public Utente setRecordPopolazione(Utente utente, int num_popolazione) {
        if(utente.getRecordBandiere() < num_popolazione){
            utente.setRecordBandiere(num_popolazione);
            utenteDao.update(utente);
        }
        return utente;
    }

}
