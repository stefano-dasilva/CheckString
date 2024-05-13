package Algoritmi;

import Addestramento.Addestramento;
import Model.Corrispondenza;
import Model.Standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizerCheckString extends CheckStringListValue {

	ArrayList<String> paroleEliminate;
	ArrayList<CheckStringSingleInput> algoritmi;


	public TokenizerCheckString() {
		this.paroleEliminate = new ArrayList<>();
		this.algoritmi = new ArrayList<>();
		algoritmi.add(new LevhensteinCheckString(2));
		algoritmi.add(new JaccardCheckString(0.75));
		algoritmi.add(new JaroCheckString(0.75));
		algoritmi.add(new DoubleMetaphoneCheckString());

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
	protected Corrispondenza check(String input, Standard standard) {


		ArrayList<String> inputTokens = new ArrayList();
		inputTokens.addAll(getTokens(input));
		ArrayList<Standard> standardTokens = new ArrayList<>();
		String[] values = standard.getValue().split("\\s+");
		//repubblica ceca -> repubblica  / ceca

		for (String value : values) {
			Standard token = new Standard(standard.getId(), standard.getCode(), value, 0);
			standardTokens.add(token);
		}

// confronta per ogni algoritmo il token dell'input con il token dello standard
		for (CheckStringSingleInput algoritmo : algoritmi){
			for (String inputToken : inputTokens) {
				for (Standard standardtoken : standardTokens){
					//  se trova una corrispondenza
					if (algoritmo.check(inputToken, standardtoken) != null) {
							// ... ritorna la corrispondenza e si ferma
							Corrispondenza corrispondenza = new Corrispondenza();
							corrispondenza.setStandard(standard);
							corrispondenza.setInput(input);
							return corrispondenza;
					}
			}
			}
	}
		return null;
	}
}
