import Algoritmi.*;
import Assets.DBmock;

import java.util.Scanner;

public class AlgoritmiTest {
    public static void main(String[] args) {

        CheckString levenstein =  new LevhensteinCheckString(2);
        CheckString jaccard = new JaccardCheckString(0.78);
        levenstein.setNext(jaccard);
        CheckString jaro = new JaroCheckString(0.75);
        jaccard.setNext(jaro);
        CheckString doubleMetaphoneCheckString = new DoubleMetaphoneCheckString();
        jaro.setNext(doubleMetaphoneCheckString);


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
