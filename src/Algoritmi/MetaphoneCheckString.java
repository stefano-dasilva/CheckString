package Algoritmi;

import org.apache.commons.codec.language.Metaphone;

public class MetaphoneCheckString extends CheckString {

    private Metaphone metaphone;

    public MetaphoneCheckString(){
        this.metaphone = new Metaphone();
    }


    @Override
    protected boolean check(String input, String standard) {
        return metaphone.isMetaphoneEqual(input,standard);
    }
}
