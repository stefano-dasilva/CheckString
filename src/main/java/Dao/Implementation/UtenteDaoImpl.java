package Dao.Implementation;
import Dao.Interface.UtenteDao;
import Model.Standard;
import Model.Utente;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;



public class UtenteDaoImpl extends BaseDaoImpl implements UtenteDao {


    @PersistenceContext

    private EntityManager manager;

    @Override
    public Utente create(Utente utente) {
        manager.persist(utente);
        return utente;
    }

    @Override
    public Utente delete(Utente utente) {
       manager.detach(utente);
       return utente;
    }

    @Override
    public Utente findByUsername(String username) {
        String jpql = "from Utente where username=:username";
        Query q = manager.createQuery(jpql);
        q.setParameter("username", username);
        try {
            return (Utente) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }


    }

    @Override
    public List<Utente> getAll() {
        return (List<Utente>) super.getAll(Utente.class);
    }

    @Override
    public void cambiaPassword(Utente utente, String nuovaPassword) {
        String jpql = "update Utente set password=:password where username=:username";
        Query q= manager.createQuery(jpql);
        q.setParameter("username", utente.getUsername());
        q.setParameter("password", nuovaPassword);

    }

    @Override
    public Utente update(Utente utente) {
        return (Utente) super.update(utente);
    }


}
