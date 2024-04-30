import Algoritmi.*;
import Assets.DBmock;

public class NewVersion {
    public static void main(String[] args) {
        CheckString lev = new LevhensteinCheckString(2);
        JaroCheckString jaro = new JaroCheckString(7.5);
        JaccardCheckString jaccardCheckString = new JaccardCheckString(7.5);
        lev.setNext(jaro);
        jaro.setNext(jaccardCheckString);
        Esito esito = lev.check("brazile");
        System.out.println(esito.getStandard().getId());
        DBmock.getIstanza().printMap();
        System.out.println(DBmock.getIstanza().getStandardTable().get(esito.getStandard().getId()).getNumRicerche());
    }
    }
