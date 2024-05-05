import Algoritmi.*;
import Model.Corrispondenza;

public class NewVersion {
    public static void main(String[] args) {


        CheckString lev = new LevhensteinCheckString(1);
        CheckString jaro = new JaroCheckString(7.5);
        CheckString jaccardCheckString = new JaccardCheckString(7.5);
        CheckString doubleMetaphone = new DoubleMetaphoneCheckString();
        CheckString inputEquals = new CheckStringInputEquals();
        CheckString tokenizer = new TokenizerCheckString();
        lev.setNext(jaro);
        jaro.setNext(jaccardCheckString);
        jaccardCheckString.setNext(doubleMetaphone);
        doubleMetaphone.setNext(inputEquals);
        inputEquals.setNext(tokenizer);
        lev.check("cambodia");


    }
    }
