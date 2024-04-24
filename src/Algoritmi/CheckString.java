package Algoritmi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public abstract class CheckString {

    private Collection<String> standards;
    private CheckString next;


    public boolean check(String input){
        standards = new ArrayList<>();
        standards.add("Philippines");
        standards.add("Philippine");
        standards.add("The islands of Philippine");
        
 ArrayList<String> stringaTokenizzata=new ArrayList();
        
 //memorizzo l'input tokenizzato in un ArrayList da usare successivamente nel ciclo for 
 stringaTokenizzata.addAll(getTokens(input));

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName());
        
       
        
        
        for(String standard : standards){
        	for(String parola:stringaTokenizzata) {
        	
            if(check(parola,standard)){
                System.out.println("Parola " + standard + " trovata con " + this.getClass().getSimpleName());
                return true;
            } 
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
    
    
    
    public ArrayList<String> getTokens(String str) {
        ArrayList<String> tokens = new ArrayList<>();
        
        // ArrayList che contiene le parole da eliminare dalla stringa
        ArrayList<String> paroleEliminate = new ArrayList<>();
        paroleEliminate.add("the");
        paroleEliminate.add("of");
        paroleEliminate.add("a");
        paroleEliminate.add("an");
        paroleEliminate.add("republic");
        
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        
        // Utilizzo un iteratore per rimuovere le parole non volute dalla lista tokens
        Iterator<String> iterator = tokens.iterator();
        while (iterator.hasNext()) {
            String parola = iterator.next();
            if (paroleEliminate.contains(parola.toLowerCase())) {
                iterator.remove(); // Rimuovi l'elemento non voluto
            }
        }
        
        return tokens;
    }
    
    
    public String toString(ArrayList<String> list) {
    	String stringaFinale=" ";
    	for(String word:list) {
    		stringaFinale+=word;
    	}
    	return stringaFinale;
    	
    }
  
}
