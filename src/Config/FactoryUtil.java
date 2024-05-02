package Config;

import Dao.Interface.AlgoritmoDao;
import Dao.Interface.CorrispondenzaDao;
import Dao.Interface.NonTrovataDao;
import Dao.Interface.StandardDao;
import Model.Standard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FactoryUtil {


   private StandardDao standardDao;
   private CorrispondenzaDao corrispondenzaDao;
   private NonTrovataDao nonTrovataDao;
   private AlgoritmoDao algoritmoDao;
   private static FactoryUtil istanza;


    private FactoryUtil(){
        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
        this.standardDao = factory.getBean("StandardDao", StandardDao.class);
        this.corrispondenzaDao = factory.getBean("CorrispondenzaDao", CorrispondenzaDao.class);
        this.nonTrovataDao = factory.getBean("NonTrovataDao", NonTrovataDao.class);
        this.algoritmoDao = factory.getBean("AlgoritmoDao", AlgoritmoDao.class);
    }

    public synchronized static FactoryUtil getIstanza() {

        if (istanza == null) {
            istanza = new FactoryUtil();
        }
        return istanza;
    }

    public AlgoritmoDao getAlgoritmoDao() {
        return algoritmoDao;
    }

    public CorrispondenzaDao getCorrispondenzaDao() {
        return corrispondenzaDao;
    }

    public NonTrovataDao getNonTrovataDao() {
        return nonTrovataDao;
    }

    public StandardDao getStandardDao() {
        return standardDao;
    }
}
