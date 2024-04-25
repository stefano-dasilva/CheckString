package Algoritmi;

import org.apache.commons.codec.language.Metaphone;

public class MetaphoneCheckString extends CheckString {

    private Metaphone metaphone;

    public MetaphoneCheckString(){
        this.metaphone = new Metaphone();
    }


    public boolean testM (String input, String standard){
        return  metaphone.isMetaphoneEqual(input,standard);
    }
    @Override
    protected boolean check(String input, String standard) {
        return metaphone.isMetaphoneEqual(input,standard);
    }
}
