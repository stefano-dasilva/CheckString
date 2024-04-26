package Algoritmi;

import Assets.DBmock;

import java.util.Map;

public class DBCheckString extends CheckString {
    @Override
    protected boolean check(String input, String standard) {
    //    System.out.println("dentro db");
        Map<String, String> ricorrenze = DBmock.getIstanza().getRicorrenze();
        if(ricorrenze == null || !ricorrenze.containsKey(input)){
            return  false;
        }
        String valore = ricorrenze.get(input);
        System.out.println("chiave : " + input + " valore : " + valore);
        if (valore == null) {
            return false;
        }
        return true;

    }
}
