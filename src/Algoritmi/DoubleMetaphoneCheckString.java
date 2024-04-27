package Algoritmi;

import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.Metaphone;

public class DoubleMetaphoneCheckString extends CheckString {


    // IN STA CLASSE SI UTILIZZA IL WRAPPER PATTERN, QUANDO VIENE ISTANZIATA SI ISTANZIA
    // ANCHE LA CLASSE DOUBLEmETAPHONE CHE è BUILT IN DI APACHE
    private DoubleMetaphone doublemetaphone;

    public DoubleMetaphoneCheckString(){
        this.doublemetaphone = new DoubleMetaphone();
    }

// METODO PURAMENTE DI TEST
    public boolean testM (String input, String standard){
        System.out.println(doublemetaphone.isDoubleMetaphoneEqual(input,standard));
        System.out.println(doublemetaphone.encode(input));
        System.out.println(doublemetaphone.encode(standard));
        return  doublemetaphone.isDoubleMetaphoneEqual(input,standard);
    }

    // FA IL CONTROLLO TRA LE DUE PAROLE DAL PUNTO DI VISTA FONETICO
    @Override
    protected boolean check(String input, String standard) {
      //  System.out.println("metaphone confronto " + input + " con " + standard);
        return doublemetaphone.isDoubleMetaphoneEqual(input,standard);
    }
}
