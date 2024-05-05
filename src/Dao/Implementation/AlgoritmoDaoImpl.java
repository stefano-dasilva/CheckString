package Dao.Implementation;

import Dao.Interface.AlgoritmoDao;
import Model.Algoritmo;
import Model.Corrispondenza;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Model.Standard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class AlgoritmoDaoImpl extends BaseDaoImpl implements AlgoritmoDao {

    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;

    @Transactional
    @Override
    public Algoritmo update(Algoritmo algoritmo) {
        return (Algoritmo) super.update(algoritmo);
    }

    @Override
    public List<Algoritmo> getAll() {
        return (List<Algoritmo>) super.getAll(Algoritmo.class);
    }


    @Transactional
    @Override
    public Algoritmo findByInputAlg(String nomealgoritmo) {
        try{
            String jpql = "from Algoritmo where nome = :nome";
            Query q = manager.createQuery(jpql);
            q.setParameter("nome", nomealgoritmo);
            System.out.println(nomealgoritmo);
            return (Algoritmo) q.getSingleResult();
        }
        catch (NoResultException exception){
            return null;
        }
    }


}
