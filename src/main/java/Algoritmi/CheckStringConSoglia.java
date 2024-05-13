package Algoritmi;

import Model.Corrispondenza;
import Model.Standard;

public abstract class CheckStringConSoglia extends CheckStringListValue {

    private int soglia;

    public CheckStringConSoglia ( int soglia){
        this.soglia = soglia;
    }



    public int getSoglia() {
        return soglia;
    }

    @Override
    public String getNameDetails(){
        return "-" + getSoglia();
    }

    @Override
    protected abstract Corrispondenza check(String input, Standard standard) ;
}

