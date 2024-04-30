package Algoritmi;

import ParoleStandard.Standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizerCheckString extends CheckStringListValue {

	ArrayList<String> paroleEliminate;


	public TokenizerCheckString() {
		this.paroleEliminate = new ArrayList<>();
	}
	
	 public ArrayList<String> getTokens(String str) {
		 ArrayList<String> tokens = new ArrayList<>();
		 readFile();
		 // ArrayList che contiene le parole da eliminare dalla stringa


		 StringTokenizer tokenizer = new StringTokenizer(str, " ");
		 while (tokenizer.hasMoreElements()) {
			 tokens.add(tokenizer.nextToken());
		 }
		 if (tokens.size() > 1){

			 // Utilizzo un iteratore per rimuovere le parole non volute dalla lista tokens
			 Iterator<String> iterator = tokens.iterator();
		 while (iterator.hasNext()) {
			 String parola = iterator.next();
			 if (paroleEliminate.contains(parola.toLowerCase())) {
				 iterator.remove(); // Rimuovi l'elemento non voluto
			 }
		 }
	 }
	        
	        return tokens;
	    }


	public void readFile(){
		try{
			File file = new File("src/Assets/LettereBandite.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()){
				String parola = scanner.nextLine();
				paroleEliminate.add(parola);
			}
			scanner.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	 
	 
	 public void  toString(ArrayList<String> list) {
	    	String stringaFinale=" ";
	    	for(String word:list) {
	    		stringaFinale+=word + " ";
	    	}
	    	System.out.println(stringaFinale);
	    	
	    }

	@Override
	protected Esito check(String input, Standard standard) {

		CheckString lev = new LevhensteinCheckString(2);
		CheckString jac = new JaccardCheckString(0.7);
		lev.setNext(jac);

		ArrayList<String> inputTokens = new ArrayList();
		inputTokens.addAll(getTokens(input));
		ArrayList<String> standardTokens = new ArrayList<>();
		standardTokens.addAll(getTokens(standard.getValue()));

		for(String inputToken : inputTokens){
			for(String standardToken : standardTokens){
				if(inputToken.equals(standardToken)){
					return new Esito(standard);
				}
			}
		}
		return null;
	}
}
