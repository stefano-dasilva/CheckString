package Algoritmi;

import Assets.DBmock;
import Model.Corrispondenza;
import Model.Standard;

public class CheckStringInputEquals extends  CheckStringSingleValue{
    @Override
    protected Corrispondenza checkSingle(String input) {
        if(DBmock.getIstanza().getRicorrenze().containsKey(input)){
            Integer chiave = DBmock.getIstanza().getRicorrenze().get(input);
            Standard standard = DBmock.getIstanza().getStandardTable().get(chiave);
            return  new Corrispondenza(standard);
        }
        return null;
    }
}
