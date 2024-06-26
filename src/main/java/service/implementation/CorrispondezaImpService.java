package service.implementation;

import Dao.Interface.AlgoritmoDao;
import Dao.Interface.CorrispondenzaDao;
import Model.Algoritmo;
import Model.Corrispondenza;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.CorrispondenzaService;
import Dao.Implementation.CorrispondenzaDaoImpl;

import java.util.List;
import java.util.Objects;

public class CorrispondezaImpService implements CorrispondenzaService {


    @Autowired
    CorrispondenzaDao corrispondenzaDao;
    @Autowired
    AlgoritmoDao algoritmoDao;


    public CorrispondezaImpService() {
    }


    @Override
    public Corrispondenza add(Corrispondenza corrispondenza)  {

        Corrispondenza c = corrispondenzaDao.findByInput(corrispondenza.getInput());

        // se c'è già una corrispondenza
        if(c != null){
            System.out.println("numero ricerche prima" + c.getNumRicerche());
            c.setNumRicerche(c.getNumRicerche() + 1);
            if(!c.getApprovata()){
                // gli cambio la corrispondenza solo se non è approvato
            c.setStandard(corrispondenza.getStandard());
            }
            if(!Objects.equals(c.getAlgoritmo_usato(), "ManualCheckString")){
                c.setAlgoritmo_usato(corrispondenza.getAlgoritmo_usato());
            }
            corrispondenzaDao.update(c);
            corrispondenza = c;
        }
        else {
            corrispondenza.setNumRicerche(1);
            System.out.println("numero ricerche nuova corrispondenza " + corrispondenza.getNumRicerche());
            corrispondenzaDao.create(corrispondenza);
        }
        if(!Objects.equals(corrispondenza.getAlgoritmo_usato(), "ManualCheckString")){

        Algoritmo a = algoritmoDao.findByInputAlg(corrispondenza.getAlgoritmo_usato());
        if( a != null){
        a.setCorrispondenzeTrovate(a.getCorrispondenzeTrovate() + 1 );
        algoritmoDao.update(a);
        }
        else{
            Algoritmo algoritmo = new Algoritmo();
            algoritmo.setNome(corrispondenza.getAlgoritmo_usato());
            algoritmo.setCorrispondenzeTrovate(1);
            algoritmoDao.create(algoritmo);
        }
        }
        return corrispondenza;
    }

    @Override
    public Corrispondenza inputEquals(String input) {
        Corrispondenza corrispondenza = corrispondenzaDao.findByInput(input);
        if( corrispondenza != null){
            if(corrispondenza.getApprovata()){
                return corrispondenza;
            }
            else
                return null;
        }
        return null;
    }

    @Override
    public Corrispondenza findByInput(String input) {
        return corrispondenzaDao.findByInput(input);
    }


    @Override
    public Corrispondenza approva(Corrispondenza corrispondenza)  {
        //inizio transazione

        Corrispondenza c = corrispondenzaDao.findByInput(corrispondenza.getInput());
        if(c != null) {
            c.setApprovata(true);
            corrispondenzaDao.update(c);
            if(!Objects.equals(c.getAlgoritmo_usato(), "ManualCheckString")){
            Algoritmo a = algoritmoDao.findByInputAlg(c.getAlgoritmo_usato());
            a.setCorrispondeApprovate(a.getCorrispondeApprovate() + 1 );
            algoritmoDao.update(a);
            }
        }

        return corrispondenza;
        //fine transazione

    }

}
