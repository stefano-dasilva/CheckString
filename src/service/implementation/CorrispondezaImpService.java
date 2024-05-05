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

            // cerca tutte le corrispondenze che hanno utilizzato di quell'algoritmo...
            List<Corrispondenza> corrispondenze_algoritmo = corrispondenzaDao.findbyAlgorithm(c.getAlgoritmo_usato());
            int approvata = 0;
            for(Corrispondenza corrispondenza_algoritmo : corrispondenze_algoritmo){
                if (corrispondenza_algoritmo.getApprovata()){
                    // se la corrispondenza cercata è stata approvata aumenta il numero di corrispondeze
                    // approvate per quell'algoritmo
                    approvata++;
                }
            }
            // ... ora cambia la percentuale di corrispondenze attrovate per quell'algoritmo
            Algoritmo algoritmo = algoritmoDao.findByInputAlg(c.getAlgoritmo_usato());
            algoritmo.setPercentualeApprovazione((100.0 * approvata) / corrispondenze_algoritmo.size());
            algoritmoDao.update(algoritmo);
        }



        return corrispondenza;
        //fine transazione

    }

}
