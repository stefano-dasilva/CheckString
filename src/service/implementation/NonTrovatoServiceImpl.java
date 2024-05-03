package service.implementation;

import Dao.Implementation.NonTrovataDaoImpl;
import Model.NonTrovata;
import service.Interface.NonTrovatoService;

public class NonTrovatoServiceImpl implements NonTrovatoService {

    private NonTrovataDaoImpl nonTrovataDao;

    public NonTrovatoServiceImpl() {
        this.nonTrovataDao=new NonTrovataDaoImpl();
    }


    @Override
    public NonTrovata inserisciNonTrovato(NonTrovata nonTrovata) throws Exception {
        NonTrovata n=nonTrovataDao.findByInput(nonTrovata.getInput());

        if(n!=null){
            nonTrovataDao.Update(nonTrovata);
        }else{
            nonTrovataDao.add(nonTrovata);
        }


        return nonTrovata;
    }


}
