package Algoritmi;

import Model.Corrispondenza;
import Model.Standard;

public class ContainsCheckString extends CheckStringListValue {


    @Override
    public Corrispondenza check (String input, Standard standard) {
        if(input.contains(standard.getValue())){
            return new Corrispondenza(standard);
        }
        else
            return null;

    }
}
