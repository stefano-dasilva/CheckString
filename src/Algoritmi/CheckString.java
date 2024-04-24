package Algoritmi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public abstract class CheckString {

    private Collection<String> standards;
    private CheckString next;


    public boolean check( String input){
        standards = new ArrayList<>();
        standards.add("Philippines");
        standards.add("Philippine");
        standards.add("The islands of Philippine");

        System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName());
        
        if(input.contains(" ")) {
        	
        }

        for(String standard : standards){
            if(check(input,standard)){
                System.out.println("Parola " + standard + " trovata con " + this.getClass().getSimpleName());
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
    
    
    
    // metodo Tokenizer
    public List<String> getTokens(String str) {
        List<String> tokens = new ArrayList<>();
        
        // ArrayList che contine le parole che non verranno analizzate nell'algoritmo
        ArrayList<String> paroleEliminate=new ArrayList();
        
        // Qua è possibile inserire le le parole da eliminare dalla Stringa con Tokenizer
        paroleEliminate.add("the");
        paroleEliminate.add("of");
        paroleEliminate.add("a");
        paroleEliminate.add("an");
        
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        // Elimino dalla Stringa le parole che non servono
        for(String parola:tokens) {
        	for(String parolaNonVoluta:paroleEliminate) {
        		if(parola.equalsIgnoreCase(parolaNonVoluta)) {
        			tokens.remove(parolaNonVoluta);
        		}
        	}
        }
        return tokens;
    }
    
    



}
