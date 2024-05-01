import Config.Beans;
import Dao.Interface.StandardDao;
import Model.Standard;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class insertINTODB {
    public static void main(String[] args) {

        List<Standard> paroleStandard = new ArrayList<>();

        try {
            File file = new File("src/Assets/Nazioni2.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String parola = scanner.nextLine();
                String codice = parola.substring(0, parola.indexOf(',') - 1).trim();
                String nome = parola.substring(parola.indexOf(',') + 1, parola.length()).trim();
                Standard standard = new Standard();
                standard.setCode(codice);
                standard.setValue(nome);
                paroleStandard.add(standard);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);

        StandardDao standardDao = factory.getBean("StandardDao",StandardDao.class);
        for(Standard standard : paroleStandard){
            standardDao.add(standard);
        }


    }
    }
