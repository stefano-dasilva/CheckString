package Algoritmi;

import Model.Corrispondenza;
import Model.Standard;

public class JaroCheckString extends CheckStringListValue implements CheckStringSingleInput {
private double soglia;

public JaroCheckString(double soglia) {
    this.soglia = soglia;
}

        // Function to calculate the
// Jaro Similarity of two Strings
        public Corrispondenza check(String s1, Standard s2)
        {

           // System.out.println("Jaro confronto " + s1 + " con " + s2);
            // If the Strings are equal
            if (s1 == s2.getValue())
                return new Corrispondenza(s2) ;

            // Length of two Strings
            int len1 = s1.length(),
                    len2 = s2.getValue().length();

            // Maximum distance upto which matching
            // is allowed
            int max_dist = (int) (Math.floor(Math.max(len1, len2) / 2) - 1);

            // Count of matches
            int match = 0;

            // Hash for matches
            int hash_s1[] = new int[s1.length()];
            int hash_s2[] = new int[s2.getValue().length()];

            // Traverse through the first String
            for (int i = 0; i < len1; i++)
            {

                // Check if there is any matches
                for (int j = Math.max(0, i - max_dist);
                     j < Math.min(len2, i + max_dist + 1); j++)

                    // If there is a match
                    if (s1.toLowerCase().charAt(i) == s2.getValue().toLowerCase().charAt(j) && hash_s2[j] == 0)
                    {
                        hash_s1[i] = 1;
                        hash_s2[j] = 1;
                        match++;
                        break;
                    }
            }

            // If there is no match
            if (match == 0)
                return null;

            // Number of transpositions
            double t = 0;

            int point = 0;

            // Count number of occurrences
            // where two characters match but
            // there is a third matched character
            // in between the indices
            for (int i = 0; i < len1; i++)
                if (hash_s1[i] == 1)
                {

                    // Find the next matched character
                    // in second String
                    while (hash_s2[point] == 0)
                        point++;

                    if (s1.charAt(i) != s2.getValue().charAt(point++) )
                        t++;
                }

            t /= 2;
            double jarosimilarity = (((double)match) / ((double)len1)
                    + ((double)match) / ((double)len2)
                    + ((double)match - t) / ((double)match))
                    / 3.0;
        //    System.out.println("score : " + jarosimilarity);


            if(jarosimilarity >= soglia){
                Corrispondenza corrispondenza = new Corrispondenza();
                corrispondenza.setStandard(s2);
                corrispondenza.setInput(s1);
                return corrispondenza;
            }
            else
               return null;

        }
}
