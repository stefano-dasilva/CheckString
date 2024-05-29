package Algoritmi;

import Config.FactoryUtil;
import Model.Corrispondenza;
import Model.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.CorrispondenzaService;

public class CheckStringInputEquals extends  CheckStringSingleValue{



    @Override
    protected Corrispondenza checkSingle(String input) {

        System.out.println("sono dentro input_equals");
        Corrispondenza corrispondenza = FactoryUtil.getIstanza().getCorrispondezaService().inputEquals(input.toLowerCase());
        if(corrispondenza != null){
            return  corrispondenza;
        }
        return null;
    }
}
