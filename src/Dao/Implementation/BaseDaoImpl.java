package Dao.Implementation;

import Dao.Interface.BaseDao;
import Model.Bean;
import Model.Corrispondenza;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BaseDaoImpl implements BaseDao {


    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;


    @Transactional
    @Override
    public  List<?> getAll(Class c) {


        String jpql = "from " + c.getSimpleName();
        Query q = manager.createQuery(jpql);
        List<?> resultList = q.getResultList();
        return resultList;
    }

    @Override
    public Object findByInput(String input,Class c) {
        try{
            String jpql = "from " + c.getSimpleName() + " where input = :input";
            Query q = manager.createQuery(jpql);
            q.setParameter("input", input);
            return q.getSingleResult();
        }
        catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Object findById(Integer id, Class c) {
        Object o = manager.find(c, id);
        return o;
    }

    @Override
    public Object create(Bean bean) {
        manager.persist(bean);
        return bean;
    }

    @Override
    public Object update(Bean bean) {
        manager.merge(bean);
        return bean;
    }
}
