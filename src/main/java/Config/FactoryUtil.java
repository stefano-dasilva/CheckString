package Config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Interface.*;

public class FactoryUtil {


    private AlgoritmoService algoritmoService;
    private CorrispondenzaService corrispondezaService;
    private NonTrovataService nonTrovataService;
    private StandardService standardService;
    private UtenteService utenteService;


    private static FactoryUtil istanza;


    private FactoryUtil() {
        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
        this.algoritmoService = factory.getBean("AlgoritmoService", AlgoritmoService.class);
        this.corrispondezaService = factory.getBean("CorrispondenzaService", CorrispondenzaService.class);
        this.nonTrovataService = factory.getBean("NonTrovataService", NonTrovataService.class);
        this.standardService = factory.getBean("StandardService", StandardService.class);
        this.utenteService = factory.getBean("UtenteService",UtenteService.class);
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


    public UtenteService getUtenteService() {
        return utenteService;
    }
}