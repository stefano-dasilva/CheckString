package Addestramento;

import Algoritmi.*;
import Config.FactoryUtil;
import Model.Algoritmo;
import service.Interface.AlgoritmoService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Addestramento {



    private Map<String, StatisticheAlgoritmo> casiSuccesso;
    private ArrayList<String> inputTest;
    private int numeroParole;
    private boolean isActive;
    private CheckString chain;
    private static Addestramento istanza;


    private Addestramento(){
        inputTest = new ArrayList<>();
        casiSuccesso = new HashMap<>();
    }

    public synchronized static Addestramento getIstanza() {

        if (istanza == null) {
            istanza = new Addestramento();
        }
        return istanza;
    }


    public void readFile(){
        // LEGGE IL FILE CHE CONTIENE L'INPUT DI ADDESTRAMENTO
        try{
            File file = new File("src/Assets/InputAddestramento.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String parola = scanner.nextLine();
                inputTest.add(parola);
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }



    public void buildChain(){
        CheckString levhensteinCheckString = new LevhensteinCheckString(2);
        CheckString metaphone = new DoubleMetaphoneCheckString();
        levhensteinCheckString.setNext(metaphone);
        CheckString containsString = new ContainsCheckString();
        metaphone.setNext(containsString);
        CheckString jaccard = new JaccardCheckString(0.75);
        containsString.setNext(jaccard);
        CheckString jaro = new JaroCheckString(0.75);
        jaccard.setNext(jaro);
        CheckString inputEquals = new CheckStringInputEquals();
        jaro.setNext(inputEquals);
        CheckString Tokenizer = new TokenizerCheckString();
        inputEquals.setNext(Tokenizer);

        this.chain = levhensteinCheckString;
    }

    public Map<String, StatisticheAlgoritmo> getCasiSuccesso() {
        return casiSuccesso;
    }


    public void addestra(){
        buildChain();
        readFile();
        setActive(true);
        numeroParole = inputTest.size();
        for(String input : inputTest) {
                chain.check(input);
        }
       AlgoritmoService algoritmoService = FactoryUtil.getIstanza().getAlgoritmoService();

        for (Map.Entry<String, StatisticheAlgoritmo> entry : casiSuccesso.entrySet()){
            algoritmoService.setSuccesso(entry.getKey(), (entry.getValue().getCasiSuccesso() * 100) / numeroParole,entry.getValue().getTempoSuccesso() / numeroParole);
        }
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }
    public List<Algoritmo> stampaClassifica(){
       List<Algoritmo> classifica = FactoryUtil.getIstanza().getAlgoritmoService().getAll();
       return  classifica;
    }
}
