package Dao.Implementation;

import Dao.Interface.StandardDao;
import Model.Corrispondenza;
import Model.Standard;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StandardDaoImpl extends BaseDaoImpl implements StandardDao {
    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;


    @Transactional
    @Override
    public Standard add(Standard standard) {
        manager.persist(standard);
        return standard;
    }

    @Override
    public List<Standard> getAll() {
        return (List<Standard>) super.getAll(Standard.class);
    }

    @Override
    public Standard findById(Integer id) {
        return (Standard) super.findById(id,Standard.class);
    }
}
