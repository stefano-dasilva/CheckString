package Assets;

import java.util.HashMap;
import java.util.Map;

public class DBmock {
    private HashMap<String, String> ricorrenze;
    private static DBmock istanza;



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

    public void printMap(){
        for (Map.Entry<String, String> entry : ricorrenze.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public HashMap<String, String> getRicorrenze() {
        return ricorrenze;
    }
}
