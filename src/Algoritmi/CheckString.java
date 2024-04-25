package Algoritmi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import Addestramento.Addestramento;
import Assets.DBmock;
import ParoleStandard.Standard;
import ParoleStandard.StandardFromLocale;
import io.github.kju2.languagedetector.LanguageDetector;
import io.github.kju2.languagedetector.language.Language;


public abstract class CheckString {

    private Collection<Standard> standards;
    private CheckString next;
    private Addestramento datiAddestramento;
    private DBmock dbmock;
    private Tokenizer tokenizer;
    private LanguageDetector languageDetector;
    private  Language lingua;
   



    public boolean check(String input){
        standards = new ArrayList<>();
        tokenizer=new Tokenizer();
        
     
       
      ArrayList<String> stringaTokenizzata=new ArrayList();
        
       //memorizzo l'input tokenizzato in un ArrayList da usare successivamente nel ciclo for 
        stringaTokenizzata.addAll(tokenizer.getTokens(input));
        
        try {
			languageDetector = new LanguageDetector();
			lingua=languageDetector.detectPrimaryLanguageOf(tokenizer.toString(stringaTokenizzata));
			if(lingua.equals(lingua.ENGLISH)) {
				StandardFromLocale standardFromLocale = new StandardFromLocale();
			       this.standards = standardFromLocale.getStandards();
				
			}else {
				StandardFromLocale standardFromLocale = new StandardFromLocale();
				       this.standards = standardFromLocale.getStandards();
			}
		
		} catch (IOException e) {
			System.out.println("Nessuna Lingua Rilevata");
			e.printStackTrace();
		}
        
               
      

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + input);
        // usa l'algoritmo confrontando la parola standard con ciascuna parola della stringa tokenizzata
        for(Standard standard : standards){
        	for(String parola:stringaTokenizzata)
        
            if(check(parola,standard.getValue())){
                System.out.println("Parola " + standard.getValue() + " trovata con " + this.getClass().getSimpleName()); 
                return true;
                }
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
