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
    public String ApprovaCorrispondeza(String corrispondenza) throws Exception {
        //inizio transazione

        Corrispondenza c= corrispondenzaDao.findByInput(corrispondenza);

        if(c!=null){
            corrispondenzaDao.Update(c);
        }else{
            corrispondenzaDao.add(c);
        }
        return corrispondenza;
        //fine transazione
















    }
}
