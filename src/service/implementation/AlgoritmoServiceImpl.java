package service.implementation;

import Dao.Implementation.AlgoritmoDaoImpl;
import Dao.Implementation.CorrispondenzaDaoImpl;
import Dao.Interface.AlgoritmoDao;
import Model.Algoritmo;
import Model.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.AlgoritmoService;

import java.util.List;

public class AlgoritmoServiceImpl implements AlgoritmoService {


    @Autowired
    AlgoritmoDao algoritmoDao;

    public AlgoritmoServiceImpl() {
    }
    @Override
    public Algoritmo setSuccesso(String nomeAlgoritmo, double percentualeSuccesso, double mediaTempo) {

        Algoritmo algoritmo = algoritmoDao.findByInputAlg(nomeAlgoritmo);
        if(algoritmo != null){
            algoritmo.setSuccesso(percentualeSuccesso);
            algoritmo.setMediaTempo(mediaTempo);
            algoritmoDao.update(algoritmo);
        }
        return  algoritmo;
    }

    @Override
    public List<Algoritmo> getAll() {
        return algoritmoDao.getAll();
    }
}
