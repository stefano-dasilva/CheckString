import Addestramento.Addestramento;
import Algoritmi.LevhensteinCheckString;
import Algoritmi.MetaphoneCheckString;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddestramentoTest {

    public static void main(String[] args) {

        LevhensteinCheckString levhensteinCheckString = new LevhensteinCheckString(2);
        LevhensteinCheckString levhensteinCheckString1 = new LevhensteinCheckString(3);
        levhensteinCheckString.setNext(levhensteinCheckString1);
        MetaphoneCheckString metaphoneCheckString = new MetaphoneCheckString();
        levhensteinCheckString1.setNext(metaphoneCheckString);
       // levhensteinCheckString.check("philipppppine");

       Addestramento addestramento = new Addestramento();
       /*
        ArrayList<String> inputIngresso = addestramento.getInputIngresso();
        for( String input : inputIngresso ){
            System.out.println(input );
        }
        */

        addestramento.addestra();
        addestramento.statistiche();
       // addestramento.printMap();

    }
    }
