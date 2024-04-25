import Algoritmi.CheckString;
import Algoritmi.ContainsCheckString;
import Algoritmi.LevhensteinCheckString;
import Algoritmi.MetaphoneCheckString;
import Assets.DBmock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DBmockTest {
    public static void main(String[] args)  {

        String parola;
        Scanner scanIn = new Scanner(System.in);
        while (true){
        parola = scanIn.nextLine();
        if(parola.equals("end")){
            break;
        }
        CheckString lv = new LevhensteinCheckString(1);
        CheckString mt = new MetaphoneCheckString();
        CheckString co = new ContainsCheckString();
        lv.setNext(mt);
        mt.setNext(co);

        lv.check(parola);
        }
        DBmock.getIstanza().printMap();
        scanIn.close();

    }

    }
