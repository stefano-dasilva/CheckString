package Addestramento;

import Algoritmi.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Addestramento {

    private Map<String, Integer> casiSuccesso;

    private ArrayList<String> inputIngresso;
    private int numeroParole;
    private boolean isActive = true;
    private CheckString chain;

    public Addestramento(){
        inputIngresso = new ArrayList<>();
        casiSuccesso = new HashMap<>();
       readFile();
       numeroParole = inputIngresso.size();
    }

    public void changeState() {
        isActive = !isActive;
    }
    public boolean isActive(){
        return  this.isActive;
    }

    public void statistiche(){
        // STAMPA LE STATISTICHE
        System.out.println(casiSuccesso.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() + " " + ((entry.getValue() * 100) / numeroParole) + "%")
                .collect(Collectors.toList()));

    }
    public void readFile(){
        // LEGGE IL FILE CHE CONTIENE L'INPUT DI ADDESTRAMENTO
        try{
            File file = new File("src/Assets/InputAddestramento.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String parola = scanner.nextLine();
                inputIngresso.add(parola);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getInputIngresso() {
        return inputIngresso;
    }

    public void buildChain(){
        // CREA UNA CHAIN OF RESPONSABILITY
        // LEVENSTEIN-> DOUBLEMETAPHONE -> CONTAINS -> JACCARD
        // PER OGNI ALGORITMO SETDATIADDESTRAMENTO(THIS) SIGNIFICA CHE L'ALGORITMO HA UN RIFERIMENTO A QUESTA
        // CLASSE ADDESTRAMENTO. GLI SERVE IL RIFERIMENTO PER SCRIVERE NELLA STRUTTURA DATI CASIDISUCCESSO
        CheckString levhensteinCheckString = new LevhensteinCheckString(1);
        CheckString metaphone = new DoubleMetaphoneCheckString();
        metaphone.setDatiAddestramento(this);
        levhensteinCheckString.setDatiAddestramento(this);
        levhensteinCheckString.setNext(metaphone);
        CheckString containsString = new ContainsCheckString();
        containsString.setDatiAddestramento(this);
        metaphone.setNext(containsString);
        CheckString jaccard = new JaccardCheckString(0.75);
        containsString.setNext(jaccard);
        jaccard.setDatiAddestramento(this);
        CheckString jaro = new JaroCheckString(0.75);
        jaccard.setNext(jaro);
        jaro.setDatiAddestramento(this);

        this.chain = levhensteinCheckString;
    }

    public Map<String, Integer> getCasiSuccesso() {
        return casiSuccesso;
    }
    public void printMap(){
        for (Map.Entry<String, Integer> entry : casiSuccesso.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println(numeroParole);
    }

    public void addestra(){
        // PER PRIMA COSA CREA UNA CHAIN OF RESPONSABILITY
        // IN SEGUITO PER OGNI PAROLA DEGLI INPUT IN INGRESSO UTILIZZA LA CHAIN
        buildChain();
        for(String input : inputIngresso) {
                chain.check(input);
        }
    }

}
