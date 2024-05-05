package Algoritmi;

import Addestramento.Addestramento;
import Config.FactoryUtil;
import Model.Corrispondenza;
import Model.NonTrovata;
import Addestramento.StatisticheAlgoritmo;


public abstract class CheckString {

    private CheckString next;


    public Corrispondenza check(String input) {

        // in questa classe singleton sono presenti i vari service
        FactoryUtil factoryUtil = FactoryUtil.getIstanza();

       // System.out.println("Provo con l'algoritmo " + this.getClass().getSimpleName() + "la parola " + input);



            double tempoInizio = System.currentTimeMillis();
        Corrispondenza corrispondenza = implementcheck(input);
        // se c'è una corrispondenza
        if(corrispondenza != null){
            // ... se non c'è un addestramento in corso
            if(!Addestramento.getIstanza().isActive()){
                // ... aggiungo alla corrispondenza trovata il nome dell'algoritmo e l'aggiungo al DB
                corrispondenza.setAlgoritmo_usato(this.getClass().getSimpleName());
                System.out.println(corrispondenza.getAlgoritmo_usato());
                factoryUtil.getCorrispondezaService().add(corrispondenza);
                return  corrispondenza;
            }
            else {
               // ... se  c'è un addestramento in corso
                // nella mappa casi successo di classe Addestramento aggiungo un caso di successo x l'algoritmo
                double tempoFine = System.currentTimeMillis();
                String chiave = this.getClass().getSimpleName();
                StatisticheAlgoritmo valore = Addestramento.getIstanza().getCasiSuccesso().getOrDefault(chiave,new StatisticheAlgoritmo());
                valore.setCasiSuccesso(valore.getCasiSuccesso() + 1);
                double tempoSuccesso = tempoFine - tempoInizio;
                valore.setTempoSuccesso(valore.getTempoSuccesso() + tempoSuccesso);
                Addestramento.getIstanza().getCasiSuccesso().put(chiave,valore);
                // ... dato che è un addestramento devo continuare anche se ho trovato una soluzione
                if(next != null){

                return next.check(input);
                }
                else
                    return null;
            }
        }
        else if (next != null) {
            double tempoFine = System.currentTimeMillis();
            String chiave = this.getClass().getSimpleName();
            StatisticheAlgoritmo valore = Addestramento.getIstanza().getCasiSuccesso().getOrDefault(chiave,new StatisticheAlgoritmo());
            double tempoSuccesso = tempoFine - tempoInizio;
            valore.setTempoSuccesso(valore.getTempoSuccesso() + tempoSuccesso);
            Addestramento.getIstanza().getCasiSuccesso().put(chiave,valore);
            return next.check(input);
        } else {
            double tempoFine = System.currentTimeMillis();
            String chiave = this.getClass().getSimpleName();
            StatisticheAlgoritmo valore = Addestramento.getIstanza().getCasiSuccesso().getOrDefault(chiave,new StatisticheAlgoritmo());
            double tempoSuccesso = tempoFine - tempoInizio;
            valore.setTempoSuccesso(valore.getTempoSuccesso() + tempoSuccesso);
            Addestramento.getIstanza().getCasiSuccesso().put(chiave,valore);

            // se non è stata trovata nessuna soluzione e non vi è un addestramento aggiungo la parola non trovata
            // nel DB
            if(!Addestramento.getIstanza().isActive()){
                NonTrovata nonTrovata = new NonTrovata();
                nonTrovata.setInput(input);
                factoryUtil.getNonTrovataService().inserisciNonTrovata(nonTrovata);
            }

            return null;
        }




    }

    protected String getName(){
        return this.getClass().getSimpleName();
    }

    public void setNext(CheckString checkString){
        this.next = checkString;
    }

    // TEMPLATE
    protected abstract Corrispondenza implementcheck(String input);



}
