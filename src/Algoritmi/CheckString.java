package Algoritmi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import Addestramento.Addestramento;
import Assets.DBmock;
import ParoleStandard.Standard;
import ParoleStandard.StandardFromFile;


public abstract class CheckString {

    private Collection<Standard> standards;
    private CheckString next;
    private Addestramento datiAddestramento;
    private DBmock dbmock;
    private Tokenizer tokenizer;



    public boolean check(String input){
        standards = new ArrayList<>();
        tokenizer=new Tokenizer();
     
       
      ArrayList<String> stringaTokenizzata=new ArrayList();
        
       //memorizzo l'input tokenizzato in un ArrayList da usare successivamente nel ciclo for 
        stringaTokenizzata.addAll(tokenizer.getTokens(input));


        StandardFromFile standardFromFile = new StandardFromFile();
        this.standards = standardFromFile.getStandards();

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + input);

        for(Standard standard : standards){
        	for(String parola:stringaTokenizzata)
        
            if(check(parola,standard.getValue())){
                System.out.println("Parola " + standard.getValue() + " trovata con " + this.getClass().getSimpleName()); }
             //   System.out.println(input + " --> " + standard.getValue());
                //if(datiAddestramento == null){
                  //  dbmock = DBmock.getIstanza();
                    //dbmock.putRicorrenza(input,standard.getValue());
                    //return true;
                //}
                //else{
                  //  String chiave = this.getClass().getSimpleName();
                   // int valore = getDatiAddestramento().getCasiSuccesso().getOrDefault(chiave,0);
                    //getDatiAddestramento().getCasiSuccesso().put(chiave,valore + 1);
                    //System.out.println("aggiunto alla chiave" + this.getClass().getSimpleName() + " + 1" + "valore ora uguale a " + valore);
                    //break;
                //}
            //}
            else{
               System.out.println("Parola " + standard.getValue() + "non trovata con " + this.getClass().getSimpleName());
               if( next != null){
                   System.out.println("procedo con il successivo\n");
                   next.check(input);

            }

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName());
            }
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
