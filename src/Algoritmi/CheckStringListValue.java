package Algoritmi;

import ParoleStandard.ParoleStandard;
import ParoleStandard.Standard;
import ParoleStandard.StandardFromFile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ParoleStandard.Standard;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ParoleStandard.StandardFromDB;


import java.util.ArrayList;
import java.util.Collection;

public abstract class CheckStringListValue extends  CheckString{

    private Collection<Standard> standards;


    public Esito implementcheck (String input){

        ParoleStandard paroleStandard = new StandardFromFile();
        this.standards = paroleStandard.getStandards();

        for (Standard standard : standards) {
            Esito esito = check(input,standard);

            if (esito != null){
                /*
                SessionFactory factory =  new Configuration().configure("Hibernate/hibernate.cfg.xml").buildSessionFactory();
                Session session = factory.openSession();
                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    System.out.println("numero ricerche : " + standard.getNumRicerche());
                    standard.setNumRicerche(standard.getNumRicerche() + 1);
                    System.out.println("numero ricerche dopo : " + standard.getNumRicerche());

                    session.update(standard);
                    tx.commit();
                } catch (HibernateException e) {
                    if (tx != null) tx.rollback();
                    e.printStackTrace();
                } finally {
                    session.close();
                }
                */
                return  esito;
            }
        }
        return null;
    }



    protected abstract  Esito check(String input, Standard standard);

}
