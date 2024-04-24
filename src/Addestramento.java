import java.util.*;
import java.util.stream.Collectors;

public class Addestramento {

    private Map<String, Integer> casiSuccesso;
    private ArrayList<String> inputIngresso;
    private int numeroParole = 100;
    private static boolean isActive = false;

    public Addestramento(){
        casiSuccesso = new HashMap<>();
        casiSuccesso.put("levenstein",3);
        casiSuccesso.put("jaccard",5);
        casiSuccesso.put("altro",4);
    }

    public void statistiche(){
        System.out.println(casiSuccesso.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() + " " + ((entry.getValue() * 100) / numeroParole) + " %")
                .collect(Collectors.toList()));

    }
}
