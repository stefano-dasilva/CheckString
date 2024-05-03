package service.implementation;

import Model.Corrispondenza;
import service.Interface.CorrispondenzaService;
import Dao.Implementation.CorrispondenzaDaoImpl;
public class CorrispondezaImpService implements CorrispondenzaService {

    CorrispondenzaDaoImpl corrispondenzaDao;

    public CorrispondezaImpService(CorrispondenzaDaoImpl corrispondenzaDao) {
        this.corrispondenzaDao = corrispondenzaDao;
    }


    @Override
    public Corrispondenza ApprovaCorrispondeza(Corrispondenza corrispondenza) throws Exception {
        //inizio transazione
        corrispondenzaDao.Update(corrispondenza);
        return corrispondenza;
        //fine transazione
















    }
}
