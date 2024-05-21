import Config.Beans;
import Dao.Interface.*;
import Model.Corrispondenza;
import Model.NonTrovata;
import Model.Standard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class DaoTest {
    public static void main(String[] args)  {


        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);

        StandardDao standardDao = factory.getBean("StandardDao", StandardDao.class);
        CorrispondenzaDao corrispondenzaDao = factory.getBean("CorrispondenzaDao", CorrispondenzaDao.class);


        List<Standard> standards = standardDao.getAll();
        /*

        Standard standard = standardDao.findById(3);
        System.out.println(standard);
        Corrispondenza corrispondenza = new Corrispondenza();
        corrispondenza.setInput("cio");
        corrispondenza.setStandard(standard);
        corrispondenzaDao.add(corrispondenza);

         */



        /*
        for( Standard standard : standards){
            System.out.println(standard.getValue());
        }f

         */

        /*
        NonTrovata nonTrovata = new NonTrovata();
        nonTrovata.setInput("SHGSGDGDG");
        NonTrovataDao nonTrovataDao = factory.getBean("NonTrovataDao", NonTrovataDao.class);
        // se non c'è la aggiunge, se no aumenta il contatore
        nonTrovataDao.add(nonTrovata);

         */

        AlgoritmoDao algoritmoDao = factory.getBean("AlgoritmoDao", AlgoritmoDao.class);
       // algoritmoDao.incrementaSucceso("LevhensteinCheckString");


        UtenteDao utenteDao=factory.getBean("UtenteDao", UtenteDao.class);





    }

    }
