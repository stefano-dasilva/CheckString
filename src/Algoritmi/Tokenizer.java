package Algoritmi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Tokenizer {
	
	
	
	public Tokenizer() {
	}
	
	 public ArrayList<String> getTokens(String str) {
	        ArrayList<String> tokens = new ArrayList<>();
	        
	        // ArrayList che contiene le parole da eliminare dalla stringa
	        ArrayList<String> paroleEliminate = new ArrayList<>();
	        paroleEliminate.add("the");
	        paroleEliminate.add("of");
	        paroleEliminate.add("a");
	        paroleEliminate.add("an");
	        paroleEliminate.add("republic");
	        paroleEliminate.add("island");
			paroleEliminate.add("san");
	        
	        
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
	 
	 
	 public void  toString(ArrayList<String> list) {
	    	String stringaFinale=" ";
	    	for(String word:list) {
	    		stringaFinale+=word + " ";
	    	}
	    	System.out.println(stringaFinale);
	    	
	    }

}
