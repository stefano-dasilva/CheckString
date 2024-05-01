package Algoritmi;

import Model.Corrispondenza;

public abstract class CheckStringSingleValue extends CheckString{

    @Override
    protected Corrispondenza implementcheck(String input) {
        return checkSingle(input);
    }

    protected abstract Corrispondenza checkSingle(String input);

}
