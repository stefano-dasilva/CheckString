package Algoritmi;

import Assets.DBmock;

public class DBCheckString extends CheckString {
    @Override
    protected boolean check(String input, String standard) {
        boolean chiavepresente = DBmock.getIstanza().getRicorrenze().containsKey(input);
        boolean valorepresente = DBmock.getIstanza().getRicorrenze().get(input).equals(standard);
        return chiavepresente && valorepresente;
    }
}
