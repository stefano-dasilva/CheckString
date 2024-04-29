import Algoritmi.CheckString;
import Algoritmi.JaccardCheckString;
import Algoritmi.JaroCheckString;
import Algoritmi.LevhensteinCheckString;

public class NewVersion {
    public static void main(String[] args) {
        CheckString lev = new LevhensteinCheckString(2);
        JaroCheckString jaro = new JaroCheckString(7.5);
        JaccardCheckString jaccardCheckString = new JaccardCheckString(7.5);
        lev.setNext(jaro);
        jaro.setNext(jaccardCheckString);
        lev.check("brazil");
    }
    }
