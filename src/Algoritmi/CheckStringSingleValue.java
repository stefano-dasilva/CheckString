package Algoritmi;

public abstract class CheckStringSingleValue extends CheckString{

    @Override
    protected Esito implementcheck(String input) {
        return checkSingle(input);
    }

    protected abstract  Esito checkSingle(String input);

}
