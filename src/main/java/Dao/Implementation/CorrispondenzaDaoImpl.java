package Dao.Implementation;

import Dao.Interface.CorrispondenzaDao;
import Model.Corrispondenza;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class CorrispondenzaDaoImpl extends BaseDaoImpl  implements CorrispondenzaDao {




    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;


  @Transactional
    @Override
    public Corrispondenza create(Corrispondenza corrispondenza) {

        return (Corrispondenza) super.create(corrispondenza);
    }


    @Override
    public Corrispondenza update(Corrispondenza corrispondenza) {

      return (Corrispondenza) super.update(corrispondenza);
    }

    @Override
    public List<Corrispondenza> findbyAlgorithm(String algoritmo) {
        String jpql = "from Corrispondenza where algoritmo_usato = :algoritmo_usato";
        Query q = manager.createQuery(jpql);
        q.setParameter("algoritmo_usato", algoritmo);
        return q.getResultList();
    }

    @Override
    public Corrispondenza inputEquals(String input) {
        return null;
    }


    @Override
    public Corrispondenza findByInput(String input) {
       return (Corrispondenza) super.findByInput(input,Corrispondenza.class);
    }

}
