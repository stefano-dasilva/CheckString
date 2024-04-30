package Algoritmi;

import Assets.DBmock;
import ParoleStandard.Standard;

public class CheckStringInputEquals extends  CheckStringSingleValue{
    @Override
    protected Esito checkSingle(String input) {
        if(DBmock.getIstanza().getRicorrenze().containsKey(input)){
            Integer chiave = DBmock.getIstanza().getRicorrenze().get(input);
            Standard standard = DBmock.getIstanza().getStandardTable().get(chiave);
            return  new Esito(standard);
        }
        return null;
    }
}
