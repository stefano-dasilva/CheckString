package service.implementation;

import Dao.Interface.AlgoritmoDao;
import Dao.Interface.CorrispondenzaDao;
import Model.Algoritmo;
import Model.Corrispondenza;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.CorrispondenzaService;
import Dao.Implementation.CorrispondenzaDaoImpl;

import java.util.List;

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
            c.setNumRicerche(c.getNumRicerche() + 1);
            if( c.getAlgoritmo_usato() != corrispondenza.getAlgoritmo_usato()){
                c.setAlgoritmo_usato(corrispondenza.getAlgoritmo_usato());
            }
            corrispondenzaDao.update(c);
        }
        else {
            corrispondenza.setNumRicerche(1);
            corrispondenzaDao.create(corrispondenza);
        }
        Algoritmo a = algoritmoDao.findByInputAlg(corrispondenza.getAlgoritmo_usato());
        a.setCorrispondenzeTrovate(a.getCorrispondenzeTrovate() + 1 );
        algoritmoDao.update(a);


        return corrispondenza;
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
            Algoritmo a = algoritmoDao.findByInputAlg(c.getAlgoritmo_usato());
            a.setCorrispondeApprovate(a.getCorrispondeApprovate() + 1 );
            algoritmoDao.update(a);
        }

        return corrispondenza;
        //fine transazione

    }

}
