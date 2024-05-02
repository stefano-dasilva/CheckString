package Algoritmi;
import Model.Corrispondenza;
import Model.Standard;

import java.util.HashSet;

public class JaccardCheckString extends CheckStringListValue implements CheckStringSingleInput{
    private double soglia;


    public JaccardCheckString(double soglia){
    this.soglia=soglia;
    }

    public Corrispondenza check(String word1, Standard word2) {
     //   System.out.println("Sto confrontando " + word1 + " con " + word2);

        // Trasforma le parole in insiemi di caratteri
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (char c : word1.toLowerCase().toCharArray()) {
            set1.add(c);
        }

        for (char c : word2.getValue().toLowerCase().toCharArray()) {
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
           Corrispondenza corrispondenza = new Corrispondenza();
           corrispondenza.setStandard(word2);
           corrispondenza.setInput(word1);
           return corrispondenza;
       } else {
           return null;
       }

    }

public double getSoglia() {
    return soglia;
}
}




