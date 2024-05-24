package service.implementation;

import Algoritmi.*;
import Config.MD5;
import Dao.Interface.UtenteDao;
import Filter.ClassificaFilter;
import Model.Corrispondenza;
import Model.NonTrovata;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.CheckStringService;
import service.Interface.CorrispondenzaService;
import service.Interface.NonTrovataService;
import service.Interface.UtenteService;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CheckStringServiceImpl implements CheckStringService {



    @Autowired
    CorrispondenzaService corrispondenzaService;

    @Autowired
    NonTrovataService nonTrovataService;


    public CheckStringServiceImpl() {}


    @Override
    public String check(String nazione) {
        CheckString lev = new LevhensteinCheckString(1);
        CheckString jacc = new JaccardCheckString(0.75);
        CheckString jaro = new JaroCheckString(0.75);
        CheckString dmeta = new DoubleMetaphoneCheckString();
        CheckString input = new CheckStringInputEquals();
        CheckString tokenizer = new TokenizerCheckString();
        lev.setNext(jacc);
        jacc.setNext(jaro);
        jaro.setNext(dmeta);
        dmeta.setNext(input);
        input.setNext(tokenizer);
        Corrispondenza corrispondenza = lev.check(nazione);
        if(corrispondenza != null){
            corrispondenzaService.add(corrispondenza);
            return corrispondenza.getStandard().getValue();
        }
        else{
            NonTrovata nonTrovata = new NonTrovata();
            nonTrovata.setInput(nazione);
            System.out.println("sono qui");
            nonTrovataService.inserisciNonTrovata(nonTrovata);
            return "non trovata";
        }
    }

}
