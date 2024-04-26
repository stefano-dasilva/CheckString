import Algoritmi.*;
import Assets.DBmock;
import ParoleStandard.Standard;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoritmiTest {
    public static void main(String[] args) {

        CheckString levenstein =  new LevhensteinCheckString(1);
        CheckString jaccard = new JaccardCheckString(0.78);
        CheckString doubleMetaphoneCheckString = new DoubleMetaphoneCheckString();
        CheckString jaro = new JaroCheckString(0.75);
        CheckString db = new DBCheckString();
        db.setNext(levenstein);
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
            if(!db.check(parola)){
                String sugg;
                System.out.println("Parola non trovata, inserisci la parola che volevi trovare : ");
                sugg = scanIn.nextLine();
                for(Standard standard : db.getStandards()){
                    System.out.println(standard.getValue());
                    if(standard.getValue().equalsIgnoreCase(sugg)){
                        System.out.println("Contenuto!");
                        DBmock.getIstanza().putRicorrenza(parola,sugg);
                    }
                }
            }
        }
        DBmock.getIstanza().printMap();
        scanIn.close();
    }
    }
