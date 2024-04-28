import ParoleStandard.Standard;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class insertINTODB {
    public static void main(String[] args) {

        List<Standard> paroleStandard = new ArrayList<>();
        SessionFactory factory;


        try {
            File file = new File("src/Assets/Nations.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String parola = scanner.nextLine();
                String codice = parola.substring(0, parola.indexOf(',') - 1).trim();
                String nome = parola.substring(parola.indexOf(',') + 1, parola.length()).trim();
                Standard standard = new Standard(codice, nome);
                paroleStandard.add(standard);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            factory = new Configuration().configure("Hibernate/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        Transaction tx = null;

        for (Standard standard : paroleStandard){

            try {
                tx = session.beginTransaction();
                session.save(standard);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            }
    }
        session.close();



    }
    }
