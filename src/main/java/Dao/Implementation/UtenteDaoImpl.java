package Dao.Implementation;
import Dao.Interface.UtenteDao;
import spring.web.vo.Filter.ClassificaFilter;
import Model.Utente;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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
    public List<Utente> getClassifica(ClassificaFilter filtro) {


        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Utente> criteriaQuery = criteriaBuilder.createQuery(Utente.class);
        Root<Utente> root = criteriaQuery.from(Utente.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filtro.getCategoriaGioco() != null) {
            System.out.println(" categoria gioco " + filtro.getCategoriaGioco());
            if (filtro.getCategoriaGioco().equals("giocoBandiere")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("recordBandiere")));
                predicates.add(criteriaBuilder.gt(root.get("recordBandiere"), 0));
            } else if (filtro.getCategoriaGioco().equals("giocoCapitali")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("recordCapitali")));
                predicates.add(criteriaBuilder.gt(root.get("recordCapitali"), 0));
            } else if( filtro.getCategoriaGioco().equals("giocoPopolazione")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("recordPopolazioni")));
                predicates.add(criteriaBuilder.gt(root.get("recordPopolazioni"), 0));

            }
            else{
                criteriaQuery.orderBy(criteriaBuilder.desc( criteriaBuilder.sum(
                        criteriaBuilder.sum(root.get("recordBandiere"), root.get("recordCapitali")),
                        root.get("recordPopolazioni"))));
                predicates.add(criteriaBuilder.gt(criteriaBuilder.sum(criteriaBuilder.sum(root.get("recordBandiere"), root.get("recordCapitali")), root.get("recordPopolazioni")), 0));

            }
        }
        if (filtro.getMinimo() != null) {
            System.out.println("getMinimo = " + filtro.getMinimo());
            if (filtro.getCategoriaGioco().equals("giocoBandiere")) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("recordBandiere"), filtro.getMinimo()));
            } else if ( filtro.getCategoriaGioco().equals("giocoCapitali")) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("recordCapitali"), filtro.getMinimo()));
            } else if(  filtro.getCategoriaGioco().equals("giocoPopolazione")) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("recordPopolazioni"), filtro.getMinimo()));
            }
            else{
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(( criteriaBuilder.sum(
                        criteriaBuilder.sum(root.get("recordBandiere"), root.get("recordCapitali")),
                        root.get("recordPopolazioni"))),filtro.getMinimo()));
            }
        }

        if (filtro.getMassimo() != null) {
            System.out.println("getMinimo = " + filtro.getMassimo());

            if ( filtro.getCategoriaGioco().equals("giocoBandiere")) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("recordBandiere"), filtro.getMassimo()));
            } else if (filtro.getCategoriaGioco().equals("giocoCapitali")) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("recordCapitali"), filtro.getMassimo()));
            } else if(filtro.getCategoriaGioco().equals("giocoPopolazione")) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("recordPopolazioni"), filtro.getMassimo()));
            }
            else{
                predicates.add(criteriaBuilder.lessThanOrEqualTo(( criteriaBuilder.sum(
                        criteriaBuilder.sum(root.get("recordBandiere"), root.get("recordCapitali")),
                        root.get("recordPopolazioni"))),filtro.getMassimo()));
            }
        }

        if (filtro.getNazione() != null && filtro.getNazione() != "" ) {
            System.out.println(filtro.getNazione());
            System.out.println("filtro.getNazione() != null");
            predicates.add(criteriaBuilder.equal(root.get("nazione"), filtro.getNazione()));
        }


        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

        return manager.createQuery(criteriaQuery).getResultList();
    }



    @Override
    public List<Utente> getAll() {
        return (List<Utente>) super.getAll(Utente.class);
    }

    @Override
    public void cambiaPassword(Utente utente, String nuovaPassword) {
        String jpql = "update Utente set password=:password where username=:username";
        Query q = manager.createQuery(jpql);
        q.setParameter("username", utente.getUsername());
        q.setParameter("password", nuovaPassword);

    }

    @Override
    public Utente update(Utente utente) {
        return (Utente) super.update(utente);
    }

    @Override
    public Utente removeImg(Utente utente) {
        String jpql = "UPDATE Utente SET img = NULL WHERE username = :username";
        Query q = manager.createQuery(jpql);
        return utente;
    }

    @Override
    public Utente updateDati(Utente u, Utente u1) {

/*
        String jpql = "UPDATE Utente u SET u.nome = :nome, u.username = :username, u.cognome = :cognome, u.nazione = :nazione, u.dataNascita = :dataNascita ";
        Query query = manager.createQuery(jpql);
        query.setParameter("nome", u1.getNome());
        query.setParameter("username", u1.getUsername());
        query.setParameter("cognome", u1.getCognome());
        query.setParameter("nazione", u1.getNazione());
        query.setParameter("dataNascita", u1.getDataNascita());
        Utente utente_modificato = query.executeUpdate();

 */
        return u;
    }


}
