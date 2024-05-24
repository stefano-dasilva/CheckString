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

    @Override
    public Utente removeImg(Utente utente) {
        String jpql= "UPDATE Utente SET img = NULL WHERE username = :username";
        Query q= manager.createQuery(jpql);
        return utente;
    }

    @Override
    public Utente updateDati(Utente u, Utente u1) {


        /*String jpql = "UPDATE Utente u SET u.nome = :nome, u.username = :username, u.cognome = :cognome, u.nazione = :nazione, u.dataNascita = :dataNascita ";
        Query query = manager.createQuery(jpql);
        query.setParameter("nome", u1.getNome());
        query.setParameter("username", u1.getUsername());
        query.setParameter("cognome", u1.getCognome());
        query.setParameter("nazione", u1.getNazione());
        query.setParameter("dataNascita", u1.getDataNascita());
        query.executeUpdate();*/

        u.setNome(u1.getNome());
        u.setUsername(u1.getUsername());
        u.setCognome(u1.getCognome());
        u.setNazione(u1.getNazione());
        u.setDataNascita(u1.getDataNascita());

        manager.merge(u);
        return u1;
    }



}
