package Algoritmi;

import Model.Corrispondenza;
import ParoleStandard.ParoleStandard;
import Model.Standard;
import ParoleStandard.StandardFromFile;


import java.util.Collection;

public abstract class CheckStringListValue extends  CheckString{

    private Collection<Standard> standards;


    public Corrispondenza implementcheck (String input){

        ParoleStandard paroleStandard = new StandardFromFile();
        this.standards = paroleStandard.getStandards();

        for (Standard standard : standards) {
            Corrispondenza corrispondenza = check(input,standard);

            if (corrispondenza != null){
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
                return corrispondenza;
            }
        }
        return null;
    }



    protected abstract Corrispondenza check(String input, Standard standard);

}
