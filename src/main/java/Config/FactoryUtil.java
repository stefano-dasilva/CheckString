package Config;

import Dao.Interface.AlgoritmoDao;
import Dao.Interface.CorrispondenzaDao;
import Dao.Interface.NonTrovataDao;
import Dao.Interface.StandardDao;
import Model.Standard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CheckStringService;
import service.Interface.AlgoritmoService;
import service.Interface.CorrispondenzaService;
import service.Interface.NonTrovataService;
import service.Interface.StandardService;
import service.implementation.AlgoritmoServiceImpl;
import service.implementation.CorrispondezaImpService;
import service.implementation.NonTrovataServiceImpl;
import service.implementation.StandardServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FactoryUtil {


    private AlgoritmoService algoritmoService;
    private CorrispondenzaService corrispondezaService;
    private NonTrovataService nonTrovataService;
    private StandardService standardService;
    private CheckStringService checkStringService;


    private static FactoryUtil istanza;


    private FactoryUtil() {
        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
        this.algoritmoService = factory.getBean("AlgoritmoService", AlgoritmoService.class);
        this.corrispondezaService = factory.getBean("CorrispondenzaService", CorrispondenzaService.class);
        this.nonTrovataService = factory.getBean("NonTrovataService", NonTrovataService.class);
        this.standardService = factory.getBean("StandardService", StandardService.class);
        this.checkStringService = factory.getBean("CheckStringService", CheckStringService.class);
    }

    public synchronized static FactoryUtil getIstanza() {

        if (istanza == null) {
            istanza = new FactoryUtil();
        }
        return istanza;
    }





    public AlgoritmoService getAlgoritmoService() {
        return algoritmoService;
    }

    public CorrispondenzaService getCorrispondezaService() {
        return corrispondezaService;
    }

    public NonTrovataService getNonTrovataService() {
        return nonTrovataService;
    }

    public StandardService getStandardService() {
        return standardService;
    }

    public CheckStringService getCheckStringService() {
        return checkStringService;
    }
}