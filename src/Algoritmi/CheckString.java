package Algoritmi;

import java.util.ArrayList;
import java.util.Collection;

import Addestramento.Addestramento;
import ParoleStandard.Standard;
import ParoleStandard.StandardFromFile;


public abstract class CheckString {

    private Collection<Standard> standards;
    private CheckString next;
    private ArrayList<String> paroleAddestramento;
    private Addestramento datiAddestramento;


    public boolean check( String input){
        standards = new ArrayList<>();
        /*
        standards.add("Philippines");
        standards.add("Philippine");
        standards.add("The islands of Philippine");

         */
        StandardFromFile standardFromFile = new StandardFromFile();
        this.standards = standardFromFile.getStandards();

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + input);

        for(Standard standard : standards){
            if(check(input,standard.getValue())){
                System.out.println("Parola " + standard.getValue() + " trovata con " + this.getClass().getSimpleName());
             //   System.out.println(input + " --> " + standard.getValue());
                if(!datiAddestramento.isActive()){
                return true;
                }
                else{
                    String chiave = this.getClass().getSimpleName();
                    int valore = getDatiAddestramento().getCasiSuccesso().getOrDefault(chiave,0);
                    getDatiAddestramento().getCasiSuccesso().put(chiave,valore + 1);
                    System.out.println("aggiunto alla chiave" + this.getClass().getSimpleName() + " + 1" + "valore ora uguale a " + valore);
                    break;
                }
            }
            else{
              //  System.out.println("Parola " + standard.getValue() + "non trovata con " + this.getClass().getSimpleName());
                // passa un altro algoritmo con setNext()
            }
        }
        if( next != null){
            System.out.println("procedo con il successivo\n");
            next.check(input);

        }
        else {
            return false;
        }
        return true;
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
