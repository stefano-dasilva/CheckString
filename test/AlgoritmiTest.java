import Algoritmi.*;
import Assets.DBmock;

import java.util.Scanner;

public class AlgoritmiTest {
    public static void main(String[] args) {

        CheckString levenstein =  new LevhensteinCheckString(2);
        CheckString jaccard = new JaccardCheckString(0.78);
        CheckString doubleMetaphoneCheckString = new DoubleMetaphoneCheckString();
        CheckString jaro = new JaroCheckString(0.75);
        levenstein.setNext(doubleMetaphoneCheckString);
        doubleMetaphoneCheckString.setNext(jaro);
        jaro.setNext(jaccard);


        String parola;
        Scanner scanIn = new Scanner(System.in);
        while (true){
            System.out.println("Scrivi un paese\n");
            parola = scanIn.nextLine();
            if(parola.equals("end")){
                break;
            }
            if(!levenstein.check(parola)){
                String sugg;
                System.out.println("Parola non trovata, inserisci la parola che volevi trovare : ");
                sugg = scanIn.nextLine();
                DBmock.getIstanza().putRicorrenza(parola,sugg);
            }
        }
        DBmock.getIstanza().printMap();
        scanIn.close();
    }
    }
