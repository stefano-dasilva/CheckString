import Algoritmi.*;
import Config.FactoryUtil;
import Model.Corrispondenza;
import service.Interface.CorrispondenzaService;

import java.util.Scanner;

public class TestInputUtente {

    public static void main(String[] args) {

        CorrispondenzaService corrispondenzaService = FactoryUtil.getIstanza().getCorrispondezaService();
        CheckString jaro = new JaroCheckString(0.75);
        CheckString jaccardCheckString = new JaccardCheckString(0.75);
       // CheckString lev = new LevhensteinCheckString(1);
        CheckString doubleMetaphone = new DoubleMetaphoneCheckString();
        CheckString inputEquals = new CheckStringInputEquals();
        CheckString tokenizer = new TokenizerCheckString();
        jaro.setNext(jaccardCheckString);
        jaccardCheckString.setNext(doubleMetaphone);
       // lev.setNext(doubleMetaphone);
        doubleMetaphone.setNext(inputEquals);
        inputEquals.setNext(tokenizer);


        String input;
        Scanner scanIn = new Scanner(System.in);
        Corrispondenza c;
        while (true) {
            System.out.println("Input utente: \n");
            input = scanIn.nextLine();
            if (input.equals("fine")) {
                break;
            }
            c = jaro.check(input);
            if( c != null){
                System.out.println(" Corrispondenza trovata : " + c.getStandard().getValue());
                System.out.println(" Approvi la corrispondenza trovata ? S approvi / N non approvi");
                input = scanIn.nextLine();
                if( input.equals("S")){
                    corrispondenzaService.approva(c);
                    System.out.println("Corrispondenza approvata!");
                }
                else{
                    System.out.println("Corrispondenza non approvata! ");
                }
            }
            else{
                System.out.println("Non è stata trovata alcuna corrispondenza");
            }
        }

    }
}
