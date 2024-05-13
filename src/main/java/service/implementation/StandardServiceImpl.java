package service.implementation;

import Dao.Implementation.AlgoritmoDaoImpl;
import Dao.Implementation.StandardDaoImpl;
import Dao.Interface.StandardDao;
import Model.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.StandardService;

import java.util.List;

public class StandardServiceImpl implements StandardService {


    @Autowired
    StandardDao standardDao;

    public StandardServiceImpl() {

    }

    @Override
    public Standard incrementaRicerche(Standard standard)  {
        Standard s = standardDao.findById(standard.getId());
        if( s != null){
            s.setNumRicerche(s.getNumRicerche() + 1);
            standardDao.update(s);
        }
        return null;
    }

    @Override
    public List<Standard> getAll() {
        return standardDao.getAll();
    }

    @Override
    public Standard findByInput(String value) {
        return standardDao.findbyName(value);
    }
}
