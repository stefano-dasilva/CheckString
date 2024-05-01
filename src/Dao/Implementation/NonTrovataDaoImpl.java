package Dao.Implementation;

import Dao.Interface.NonTrovataDao;
import Model.Corrispondenza;
import Model.NonTrovata;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class NonTrovataDaoImpl extends BaseDaoImpl implements NonTrovataDao {


    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;

    @Override
    public NonTrovata add(NonTrovata nonTrovata) {
        NonTrovata t = findByInput(nonTrovata.getInput());
        if (t != null) {
            t.setNumRicerche(t.getNumRicerche() + 1);
            manager.merge(t);
        } else {
            nonTrovata.setNumRicerche(0);
            manager.persist(nonTrovata);
        }
        return nonTrovata;
    }



    @Override
    public NonTrovata findByInput(String input) {
       return (NonTrovata) super.findByInput(input,NonTrovata.class);

    }
}
