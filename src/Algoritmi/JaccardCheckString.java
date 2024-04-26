package Algoritmi;
import java.util.HashSet;
import java.util.Set;
public class JaccardCheckString extends CheckString{
    private double soglia;


    public JaccardCheckString(double soglia){
    this.soglia=soglia;
    }

    public boolean check(String word1, String word2) {
     //   System.out.println("Sto confrontando " + word1 + " con " + word2);

        // Trasforma le parole in insiemi di caratteri
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (char c : word1.toLowerCase().toCharArray()) {
            set1.add(c);
        }

        for (char c : word2.toLowerCase().toCharArray()) {
            set2.add(c);
        }

        // Calcola l'intersezione tra i due insiemi
        HashSet<Character> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Calcola l'unione dei due insiemi
        HashSet<Character> union = new HashSet<>(set1);
        union.addAll(set2);

        // Calcola la similarità di Jaccard
        double intersectionSize = intersection.size();
        double unionSize = union.size();
        double interunion = intersectionSize / unionSize;
    //    System.out.println(interunion);
       if (interunion >= getSoglia()){
           return true;
       } else {
           return false;
       }

    }

public double getSoglia() {
    return soglia;
}
}




