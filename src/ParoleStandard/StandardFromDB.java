package ParoleStandard;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StandardFromDB implements ParoleStandard {

    List<Standard> paroleStandard = new ArrayList<>();
    // CLASSE SESSIONFACTORY SERVA AD HIBERNATE PER LE SUE TRANSACTION
    private static SessionFactory factory;


    // QUANDO ISTANZIO L'OGGETTO CHIAMO  LA FUNZIONE DBCONNECTION ( SOTTO ) PER ISTANZIARE UNA CONNESSIONE
    public StandardFromDB()  {
        DBconnection();
    }

    public void DBconnection() {

        // VIENE PROVATA UNA CONNESSIONE : DOPO  CONFIGURATION è PRESENTE IL PERCORSO DOVE è ALLOCATO
        // IL FILE DI CONFIGURAZIONE DI HIBERNATE
        try {
            factory = new Configuration().configure("Hibernate/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }


    // QUESTA è UN OPERAZIONE DI GET DAL DB
    @Override
    public List<Standard> getStandards() {
        // VIENE CREATA UNA SESSIONE
        Session session = factory.openSession();
        Transaction tx = null;
        // QUI VERRA SALVATA LA LISTA DI STANDARD PRESA DAL DB
        List<Standard> standards = new ArrayList<>();

        try {
            // VIENE INIZIATA LA TRANSACTION
            tx = session.beginTransaction();
            // VIENE EFFETTUATA UNA SELECT DI TUTTI GLI ELEMENTI STANDARD PRESENTI NEL DB
            // IN FROM VA SPECIFICATO IL NOME DELLA CLASSE JAVA ( CHE PRECEDENTEMENTE è STATA ISTANZIATA )
            standards = session.createQuery("FROM Standard").list();
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return standards;
    }

}
