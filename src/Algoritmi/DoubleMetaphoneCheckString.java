package Algoritmi;

import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.Metaphone;

public class DoubleMetaphoneCheckString extends CheckString {

    private DoubleMetaphone doublemetaphone;

    public DoubleMetaphoneCheckString(){
        this.doublemetaphone = new DoubleMetaphone();
    }


    public boolean testM (String input, String standard){
        System.out.println(doublemetaphone.isDoubleMetaphoneEqual(input,standard));
        System.out.println(doublemetaphone.encode(input));
        System.out.println(doublemetaphone.encode(standard));
        return  doublemetaphone.isDoubleMetaphoneEqual(input,standard);
    }
    @Override
    protected boolean check(String input, String standard) {
        return doublemetaphone.isDoubleMetaphoneEqual(input,standard);
    }
}
