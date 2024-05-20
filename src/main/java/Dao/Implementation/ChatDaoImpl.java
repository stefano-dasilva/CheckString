package Dao.Implementation;

import Dao.Interface.ChatDao;
import Model.Chat;
import Model.Utente;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ChatDaoImpl implements ChatDao {

    @PersistenceContext // Annotation figlia di Inject (Autowired)
    //@PersistenceContext(type=PersistenceContextType.TRANSACTION) // opzioni EXTENDED o TRANSACTION (default)
    //@PersistenceContext(type=PersistenceContextType.EXTENDED) // opzioni EXTENDED o TRANSACTION (default)
    private EntityManager manager;


    @Transactional
    @Override
    public List<Chat> findChatsByUser(Utente utente) {

        String jpql = "SELECT c FROM Chat c WHERE c.user1 = :username OR c.user2 = :username";
        Query q = manager.createQuery(jpql);
        q.setParameter("username", utente.getUsername());
        return q.getResultList();

    }
}
