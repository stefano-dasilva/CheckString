import java.util.HashMap;

public class DBmock {
    private HashMap<String, String> ricorrenze;



    public DBmock () {
        ricorrenze = new HashMap<>();
    }

    public HashMap<String, String> getRicorrenze() {
        return ricorrenze;
    }
}
