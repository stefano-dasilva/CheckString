package Algoritmi;

import Config.FactoryUtil;
import Model.Corrispondenza;
import Model.Standard;

public class CheckStringInputEquals extends  CheckStringSingleValue{
    @Override
    protected Corrispondenza checkSingle(String input) {
        Corrispondenza corrispondenza = FactoryUtil.getIstanza().getCorrispondezaService().findByInput(input);
        if(corrispondenza != null){
            return  corrispondenza;
        }
        return null;
    }
}
