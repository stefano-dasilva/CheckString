package Algoritmi;

import Config.FactoryUtil;
import Model.Corrispondenza;
import ParoleStandard.ParoleStandard;
import Model.Standard;
import ParoleStandard.StandardFromFile;


import javax.xml.stream.FactoryConfigurationError;
import java.util.Collection;

public abstract class CheckStringListValue extends  CheckString{

    private Collection<Standard> standards;


    public Corrispondenza implementcheck (String input){
/*
        ParoleStandard paroleStandard = new StandardFromFile();
        this.standards = paroleStandard.getStandards();

 */
        this.standards = FactoryUtil.getIstanza().getStandardDao().getAll();

        for (Standard standard : standards) {
            Corrispondenza corrispondenza = check(input,standard);

            if (corrispondenza != null){
                FactoryUtil.getIstanza().getStandardDao().incrementaNumRicerche(standard.getValue());
                return corrispondenza;
            }
        }
        return null;
    }



    protected abstract Corrispondenza check(String input, Standard standard);

}
