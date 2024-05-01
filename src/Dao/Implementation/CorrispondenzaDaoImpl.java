package Dao.Implementation;

import Dao.Interface.CorrispondenzaDao;
import Model.Corrispondenza;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

public class CorrispondenzaDaoImpl extends BaseDaoImpl  implements CorrispondenzaDao {

    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;


    @Transactional
    @Override
    public Corrispondenza add(Corrispondenza corrispondenza) {

        Corrispondenza c = findByInput(corrispondenza.getInput());

        if(c != null){
            c.setNumRicerche(c.getNumRicerche() + 1);
            manager.merge(c);
        }
        else{
            corrispondenza.setNumRicerche(0);
            manager.persist(corrispondenza);
        }
        return corrispondenza;
    }

    @Override
    public Corrispondenza findByInput(String input) {
       return (Corrispondenza) super.findByInput(input,Corrispondenza.class);
    }
}
