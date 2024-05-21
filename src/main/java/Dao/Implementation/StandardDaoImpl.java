package Dao.Implementation;

import Dao.Interface.StandardDao;
import Model.Algoritmo;
import Model.Corrispondenza;
import Model.Standard;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class StandardDaoImpl extends BaseDaoImpl implements StandardDao {
    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;


    @Transactional
    @Override
    public Standard create(Standard standard) {
        standard.setNumRicerche(0);
        manager.persist(standard);
        return standard;
    }

    @Override
    public Standard update(Standard standard) {
       return (Standard) super.update(standard);
    }

    @Override
    public List<Standard> getAll() {
        return (List<Standard>) super.getAll(Standard.class);
    }

    @Override
    public Standard findById(Integer id) {
        return (Standard) super.findById(id,Standard.class);
    }




    @Override
    public Standard findbyName(String nomepaese) {
        try{
            String jpql = "from Standard where value = :nomepaese";
            Query q = manager.createQuery(jpql);
            q.setParameter("nomepaese", nomepaese);
            System.out.println(nomepaese);
            return (Standard) q.getSingleResult();
        }
        catch (NoResultException exception){
            return null;
        }
    }




}
