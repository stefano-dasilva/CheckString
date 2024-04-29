package Algoritmi;

import ParoleStandard.Standard;

public class ContainsCheckString extends CheckStringListValue {


    @Override
    public Esito check (String input, Standard standard) {
        if(input.contains(standard.getValue())){
            return new Esito(standard);
        }
        else
            return null;

    }
}
