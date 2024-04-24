package Algoritmi;

import java.util.ArrayList;
import java.util.Collection;

import ParoleStandard.Standard;
import ParoleStandard.StandardFromFile;


public abstract class CheckString {

    private Collection<Standard> standards;
    private CheckString next;


    public boolean check( String input){
        standards = new ArrayList<>();
        /*
        standards.add("Philippines");
        standards.add("Philippine");
        standards.add("The islands of Philippine");

         */
        StandardFromFile standardFromFile = new StandardFromFile();
        this.standards = standardFromFile.getStandards();

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName());

        for(Standard standard : standards){
            if(check(input,standard.getValue())){
                System.out.println("Parola " + standard.getValue() + " trovata con " + this.getClass().getSimpleName() + "\n");
                System.out.println(input + " --> " + standard.getValue());

                return true;
            }
            else{
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
    // TEMPLATE
    protected abstract boolean check(String input, String standard);



}
