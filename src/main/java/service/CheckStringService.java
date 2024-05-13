package service;
import Algoritmi.*;
import Model.Corrispondenza;

public class CheckStringService {

    private CheckString checkString;

    public CheckStringService() {

    }

    public CheckString getCheckString() {
        return checkString;
    }


    public CheckString buildChain(){
        CheckString lev = new LevhensteinCheckString(1);
        CheckString jacc = new JaccardCheckString(0.75);
        CheckString jaro = new JaroCheckString(0.75);
        CheckString dmeta = new DoubleMetaphoneCheckString();
        CheckString input = new CheckStringInputEquals();
        CheckString tokenizer = new TokenizerCheckString();
        lev.setNext(jacc);
        jacc.setNext(jaro);
        jaro.setNext(dmeta);
        dmeta.setNext(input);
        input.setNext(tokenizer);
        return lev;
    }

}
