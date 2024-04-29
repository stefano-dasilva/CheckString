package Algoritmi;

import ParoleStandard.ParoleStandard;
import ParoleStandard.Standard;
import ParoleStandard.StandardFromFile;

import java.util.ArrayList;
import java.util.Collection;

public abstract class CheckStringListValue extends  CheckString{

    private Collection<Standard> standards;


    public Esito implementcheck (String input){

        ParoleStandard paroleStandard = new StandardFromFile();
        this.standards = paroleStandard.getStandards();

        for (Standard standard : standards) {
            Esito esito = check(input,standard);
            if (esito != null){
                return  esito;
            }
        }
        return null;
    }



    protected abstract  Esito check(String input, Standard standard);

}
