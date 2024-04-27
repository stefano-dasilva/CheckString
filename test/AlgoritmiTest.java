import Algoritmi.*;
import Assets.DBmock;
import ParoleStandard.Standard;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgoritmiTest {
    public static void main(String[] args) {
        ArrayList<String> suggerimenti = new ArrayList<>();

        // QUESTO TEST POI SARà UTILIZZATO COME MAIN

        // CREA LA CHAIN OF RESPONSABILITY
        CheckString levenstein = new LevhensteinCheckString(1);
        CheckString jaccard = new JaccardCheckString(0.78);
        CheckString doubleMetaphoneCheckString = new DoubleMetaphoneCheckString();
        CheckString jaro = new JaroCheckString(0.85);
        levenstein.setNext(doubleMetaphoneCheckString);
        doubleMetaphoneCheckString.setNext(jaro);
        jaro.setNext(jaccard);


        String parola;
        Scanner scanIn = new Scanner(System.in);
        while (true) {
            // VIENE CHIESTO ALL'UTENTE DI SCRIVERE UN PAESE
            System.out.println("Scrivi un paese\n");
            parola = scanIn.nextLine();
            // SE VIENE SCRITTO END TERMINA L'INPUT
            if (parola.equals("end")) {
                break;
            }
            // VA AD AZIONARE LA CHAIN OF RESPONSABILITY, SUGGERIMENTI RAPPRESENTA LE PAROLE SIMILI
            // A QUELLA CHE VIENE FORNITA DALL'UTENTE
            suggerimenti = levenstein.check(parola);

            if (suggerimenti == null) {
                // SE NON VI è NESSUN SUGGERIMENTO ( SUGGERIMENTI = NULL) QUESTA è UNA SOLUZIONE AL PUNTO 4) DELLA CONSEGNA
                // VIENE CHIESTO ALL'UTENTE CHE PAESE INTENDEVA
                // UNA VOLTA VERIFICATO CHE IL PAESE ESISTE EFFETTIVAMENTE CONTROLLANDO
                // LA LISTA DI NAZIONI VIENE CREATA
                // LA CORRISPONDENZA TRA CIò CHE HA INSERITO L'UTENTE ED IL PAESE X
                // ES : RPC -> CINA
                String sugg;
                System.out.println("Parola non trovata, inserisci la parola che volevi trovare : ");
                sugg = scanIn.nextLine();
                // QUI VIENE FATTO IL CONTROLLO CHE ESISTA LA STRINGA INSERITA NELLA LISTA DEI PAESI
                for (Standard standard : levenstein.getStandards()) {
                    if (standard.getValue().equalsIgnoreCase(sugg)) {
                        DBmock.getIstanza().putRicorrenza(parola, sugg);
                    }
                }
            } else {
                // SE INVECE SUGGERIMENTI NON è NULL E QUINDI ESISTONO/ESITE UNA LISTA DI SUGGERIMENTI
                // OVVERO ESISTONO PAROLE SIMILI A QUELLA INSERITA
                // VIENE/VENGONO MOSTRATE A SCHERMO
                System.out.println("forse cercavi : ");
                int i = 1;
                if (suggerimenti.size() > 1) {
                    // SE CI SONO PIU DI UNA PAROLA SIMILI ALLORA VENGONO MOSTRATE TUTTE A SCHERMO
                    for (String suggerimento : suggerimenti) {
                        System.out.println(i + " ) " + suggerimento);
                        i++;
                    }
                    // IL PROGRAMMA DOPO AVERLE MOSTRATE CHIEDE ALL'UTENTE DI INSERIRE IL NUMERO DELLA
                    // NAZIONE A CUI FACEVA RIFERIMENTO

                    System.out.println("Quale intendevi?");
                    int command;
                    command = scanIn.nextInt();
                    scanIn.nextLine();
                    if (command <= suggerimenti.size()) {
                        // SE VIENE INSERITO UN NUMERO CHE NON è ASSURDO VIENE CREATA LA CORRISPONDENZA
                        DBmock.getIstanza().putRicorrenza(parola, suggerimenti.get(command - 1));
                    }
                }
                else
                {
                    // SE VI è UN SOLO SUGGERIMENTO , LO STAMPA SINGOLARMENTE
                    System.out.println(suggerimenti.get(0));
                    DBmock.getIstanza().putRicorrenza(parola, suggerimenti.get(0));
                }
            }
        }
        // STAMPA LA STRUTTURA DATI CHE MOSTRA TUTTE LE RICORRENZE
        DBmock.getIstanza().printMap();
        scanIn.close();
    }
}
