import Algoritmi.*;
import Assets.DBmock;

import java.util.Scanner;

public class AlgoritmiTest {
    public static void main(String[] args) {

        CheckString levenstein =  new LevhensteinCheckString(1);
        CheckString jaccard = new JaccardCheckString(0.75);
        levenstein.setNext(jaccard);
        CheckString contains = new ContainsCheckString();

        CheckString doubleMetaphoneCheckString = new DoubleMetaphoneCheckString();
        jaccard.setNext(doubleMetaphoneCheckString);
        doubleMetaphoneCheckString.setNext(contains);

        String parola;
        Scanner scanIn = new Scanner(System.in);
        while (true){
            parola = scanIn.nextLine();
            if(parola.equals("end")){
                break;
            }
            levenstein.check(parola);
        }
        DBmock.getIstanza().printMap();
        scanIn.close();
    }
    }
