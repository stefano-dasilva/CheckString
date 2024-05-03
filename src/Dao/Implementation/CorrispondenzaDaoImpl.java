package Dao.Implementation;

import Dao.Interface.CorrispondenzaDao;
import Model.Corrispondenza;

import javax.persistence.*;
import javax.transaction.Transactional;

public class CorrispondenzaDaoImpl extends BaseDaoImpl  implements CorrispondenzaDao {




    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;


  @Transactional
    @Override
    public Corrispondenza add(Corrispondenza corrispondenza) {

            corrispondenza.setNumRicerche(1);
            manager.persist(corrispondenza);

        return corrispondenza;
    }



    @Override
    public Corrispondenza findByInput(String input) {
       return (Corrispondenza) super.findByInput(input,Corrispondenza.class);
    }

    @Override
    public Corrispondenza Update(Corrispondenza corrispondenza) {

        Corrispondenza c=findByInput(corrispondenza.getInput());

        c.setNumRicerche(c.getNumRicerche()+1);
        return c;
    }

}
