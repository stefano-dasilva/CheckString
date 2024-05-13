package Algoritmi;

import Addestramento.Addestramento;
import Assets.DBlist;
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
        this.standards = DBlist.getIstanza().getStandardList();

        for (Standard standard : standards) {
            Corrispondenza corrispondenza = check(input,standard);

            // se c'è una corrispondenza
            if (corrispondenza != null ){
                // ... e non c'è un addestramento attivo
                if(!Addestramento.getIstanza().isActive()){
                    // ... aumento il numero di ricerche di quello standard
                FactoryUtil.getIstanza().getStandardService().incrementaRicerche(standard);
                }
                return corrispondenza;
            }
        }
        return null;
    }



    protected abstract Corrispondenza check(String input, Standard standard);

}
