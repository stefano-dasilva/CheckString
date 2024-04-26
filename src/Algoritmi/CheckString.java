package Algoritmi;

import java.util.ArrayList;
import java.util.Collection;
import Addestramento.Addestramento;
import Assets.DBmock;
import ParoleStandard.ParoleStandard;
import ParoleStandard.Standard;
import ParoleStandard.StandardFromFile;



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

        ArrayList<String> paroleSimili = new ArrayList<>();
        ArrayList<String> inputTokenizzato = new ArrayList();
        inputTokenizzato.addAll(tokenizer.getTokens(input));

        ParoleStandard paroleStandard = new StandardFromFile();
        this.standards = paroleStandard.getStandards();

        parolaTrovata = false;

        for(String tokenized : inputTokenizzato){
            System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + tokenized);




            for (Standard standard : standards) {
                ArrayList<String> standardTokenizzato = new ArrayList();
                standardTokenizzato.addAll(tokenizer.getTokens(standard.getValue()));
                for(String standardToken : standardTokenizzato){
                if (check(tokenized, standardToken)) {
                    parolaTrovata = true;
                    System.out.println("Parola " + standard.getValue() + " trovata con " + this.getClass().getSimpleName());
                    //  System.out.println(input + " --> " + standard.getValue());
                    paroleSimili.add(standard.getValue());

                    /*
                    if (datiAddestramento == null) {
                        dbmock = DBmock.getIstanza();
                        dbmock.putRicorrenza(input, standard.getValue());
                        paroleSimili.add(standard.getValue());
                        // return true;
                    } else {
                        String chiave = this.getClass().getSimpleName();
                        int valore = getDatiAddestramento().getCasiSuccesso().getOrDefault(chiave, 0);
                        getDatiAddestramento().getCasiSuccesso().put(chiave, valore + 1);
                        System.out.println("aggiunto alla chiave" + this.getClass().getSimpleName() + " + 1" + "valore ora uguale a " + valore);
                        break;
                    }

                     */
                }
            }
        }
    }
        if (parolaTrovata) {
            boolean parolaEsatta = false;
            for( String parolasimile : paroleSimili){
                if(parolasimile.equalsIgnoreCase(input)){
                    parolaEsatta = true;
                }
            }

            if(parolaEsatta){
                System.out.println(input);
            }
            else{
                for( String parolasimile : paroleSimili) {
                    if(check(input,parolasimile)){
                        System.out.println(parolasimile);
                    }

                }

            }
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

    public Collection<Standard> getStandards() {
        return standards;
    }

    // TEMPLATE
    protected abstract boolean check(String input, String standard);



}
