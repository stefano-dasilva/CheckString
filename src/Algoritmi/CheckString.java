package Algoritmi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import Addestramento.Addestramento;
import Assets.DBmock;
import ParoleStandard.ParoleStandard;
import ParoleStandard.Standard;
import ParoleStandard.StandardFromFile;
import ParoleStandard.StandardFromLocale;
import io.github.kju2.languagedetector.LanguageDetector;
import io.github.kju2.languagedetector.language.Language;


public abstract class CheckString {

    private Collection<Standard> standards;
    private CheckString next;
    private Addestramento datiAddestramento;
    private DBmock dbmock;
    private Tokenizer tokenizer;

    private boolean parolaTrovata;


    public boolean check( String input) {
        standards = new ArrayList<>();
        tokenizer = new Tokenizer();

        ArrayList<String> inputTokenizzato = new ArrayList();
        inputTokenizzato.addAll(tokenizer.getTokens(input));

        ParoleStandard paroleStandard = new StandardFromFile();
        this.standards = paroleStandard.getStandards();

        parolaTrovata = false;

        for(String tokenized : inputTokenizzato){
            System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + tokenized);

            for (Standard standard : standards) {

            if (check(tokenized, standard.getValue())) {
                parolaTrovata = true;
                System.out.println("Parola " + standard.getValue() + " trovata con " + this.getClass().getSimpleName());
                System.out.println(input + " --> " + standard.getValue());
                if (datiAddestramento == null) {
                    dbmock = DBmock.getIstanza();
                    dbmock.putRicorrenza(input, standard.getValue());
                    return true;
                } else {
                    String chiave = this.getClass().getSimpleName();
                    int valore = getDatiAddestramento().getCasiSuccesso().getOrDefault(chiave, 0);
                    getDatiAddestramento().getCasiSuccesso().put(chiave, valore + 1);
                    System.out.println("aggiunto alla chiave" + this.getClass().getSimpleName() + " + 1" + "valore ora uguale a " + valore);
                    break;
                }
            }
        }
    }
        if (parolaTrovata) {
            return true;
        } else if (next != null) {
            System.out.println("procedo con il successivo\n");
            return next.check(input);
        } else {
            return false;
        }
    }
    protected String getName(){
        return this.getClass().getSimpleName();
    }

    public void setNext(CheckString checkString){
        this.next = checkString;
    }

    public void setDatiAddestramento(Addestramento datiAddestramento) {
        this.datiAddestramento = datiAddestramento;
    }

    public Addestramento getDatiAddestramento() {
        return datiAddestramento;
    }

    // TEMPLATE
    protected abstract boolean check(String input, String standard);



}
