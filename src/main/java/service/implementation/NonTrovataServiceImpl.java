package service.implementation;

import Dao.Implementation.NonTrovataDaoImpl;
import Dao.Interface.NonTrovataDao;
import Model.NonTrovata;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.NonTrovataService;

public class NonTrovataServiceImpl implements NonTrovataService {



    @Autowired
    private NonTrovataDao nonTrovataDao;

    public NonTrovataServiceImpl() {
        this.nonTrovataDao=new NonTrovataDaoImpl();
    }


    @Override
    public NonTrovata inserisciNonTrovata(NonTrovata nonTrovata)  {

        NonTrovata n = nonTrovataDao.findByInput(nonTrovata.getInput());

        if(n != null){

            n.setNumRicerche(n.getNumRicerche() + 1);
            nonTrovataDao.update(n);

        }else{

            nonTrovata.setNumRicerche(1);
            nonTrovataDao.create(nonTrovata);

        }

        return nonTrovata;
    }

    @Override
    public NonTrovata rimuoviNonTrovata(NonTrovata nonTrovata) throws Exception {

        NonTrovata n = nonTrovataDao.findByInput(nonTrovata.getInput());

        if(n != null){
            nonTrovataDao.delete(nonTrovata);
        }else{
            System.out.println("Nessun elemento corrispondente");
        }

        return nonTrovata;
    }



}
