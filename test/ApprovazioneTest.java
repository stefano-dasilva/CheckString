import Config.FactoryUtil;
import Model.Corrispondenza;
import service.Interface.CorrispondenzaService;

public class ApprovazioneTest {

    public static void main(String[] args) {

        CorrispondenzaService corrispondenzaService = FactoryUtil.getIstanza().getCorrispondezaService();
        Corrispondenza corrispondenza = new Corrispondenza();
        corrispondenza.setInput("bras");
        corrispondenzaService.approva(corrispondenza);


    }
    }
