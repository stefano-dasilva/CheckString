package Assets;

import ParoleStandard.Standard;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DBmock {

    // STRUTTURA DATI DELLE RICORRENZE
    // ESEMPIO FILI-> FILIPPINE, PHILI->FILIPPINE MALT-> MALI ECC ECC
    private HashMap<String, Standard> ricorrenze;
    private Map<String, Integer> casiSuccesso;
    private static DBmock istanza;

    // QUESTA CLASSE RAPPRESENTA PIU O MENO LA TABELLA DEL DB
    // COME SI PUO VEDERE è STATO UTILIZZATO IL SINGLETON, IN MODO CHE VI
    // SIA UNA SOLO ISTANZA DI STA CLASSE IN GIRO PER IL PROGRAMMA
    // E TUTTI FACCIANO RIFERIMENTO ALLA STESSA UNICA ISTANZA

    private DBmock(){
        ricorrenze = new HashMap<>();
        casiSuccesso = new HashMap<>();
    }

    public synchronized static DBmock getIstanza() {

        if (istanza == null) {
            istanza = new DBmock();
        }
        return istanza;
    }

    public void putRicorrenza(String input, Standard corrispondenza) {
        this.ricorrenze.put(input,corrispondenza);
    }

    // STAMPA LA STRUTTURA DATI
    public void printMap(){
        for (Map.Entry<String, Standard> entry : ricorrenze.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().getValue());
        }
    }

    public HashMap<String, Standard> getRicorrenze() {
        return ricorrenze;
    }

    public Map<String, Integer> getCasiSuccesso() {
        return casiSuccesso;
    }

    public void statistiche(){
        // STAMPA LE STATISTICHE
        System.out.println(casiSuccesso.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() + " " + ((entry.getValue() * 100) / 150) + "%")
                .collect(Collectors.toList()));

    }
}
