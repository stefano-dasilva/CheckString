import Algoritmi.*;
import Assets.DBmock;
import Model.Corrispondenza;

public class NewVersion {
    public static void main(String[] args) {
        CheckString lev = new LevhensteinCheckString(1);
        CheckString jaro = new JaroCheckString(7.5);
        CheckString jaccardCheckString = new JaccardCheckString(7.5);
        CheckString tokenizer = new TokenizerCheckString();
        lev.setNext(jaro);
        jaro.setNext(jaccardCheckString);
        jaccardCheckString.setNext(tokenizer);
        Corrispondenza corrispondenza = lev.check("ira");
        System.out.println(corrispondenza.getStandard().getId());
        System.out.println(corrispondenza.getStandard().getValue());

        DBmock.getIstanza().printMap();
        System.out.println(DBmock.getIstanza().getStandardTable().get(corrispondenza.getStandard().getId()).getNumRicerche());
    }
    }
