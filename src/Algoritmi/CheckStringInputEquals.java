package Algoritmi;

import Assets.DBmock;

public class CheckStringInputEquals extends  CheckStringSingleValue{
    @Override
    protected Esito checkSingle(String input) {
        if(DBmock.getIstanza().getRicorrenze().containsKey(input)){
            return  new Esito(DBmock.getIstanza().getRicorrenze().get(input));
        }
        return null;
    }
}
