package Assets;

import java.util.HashMap;
import java.util.Map;

public class DBmock {

    // STRUTTURA DATI DELLE RICORRENZE
    // ESEMPIO FILI-> FILIPPINE, PHILI->FILIPPINE MALT-> MALI ECC ECC
    private HashMap<String, String> ricorrenze;
    private static DBmock istanza;

    // QUESTA CLASSE RAPPRESENTA PIU O MENO LA TABELLA DEL DB
    // COME SI PUO VEDERE è STATO UTILIZZATO IL SINGLETON, IN MODO CHE VI
    // SIA UNA SOLO ISTANZA DI STA CLASSE IN GIRO PER IL PROGRAMMA
    // E TUTTI FACCIANO RIFERIMENTO ALLA STESSA UNICA ISTANZA

    private DBmock(){
        ricorrenze = new HashMap<>();
    }

    public synchronized static DBmock getIstanza() {

        if (istanza == null) {
            istanza = new DBmock();
        }
        return istanza;
    }

    public void putRicorrenza(String input, String corrispondenza) {
        this.ricorrenze.put(input,corrispondenza);
    }

    // STAMPA LA STRUTTURA DATI
    public void printMap(){
        for (Map.Entry<String, String> entry : ricorrenze.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public HashMap<String, String> getRicorrenze() {
        return ricorrenze;
    }
}
