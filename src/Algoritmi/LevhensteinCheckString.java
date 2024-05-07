package Algoritmi;

import Model.Corrispondenza;
import Model.Standard;

public class LevhensteinCheckString extends CheckStringListValue implements CheckStringSingleInput {
    private int soglia;

    public LevhensteinCheckString(int soglia) {
        this.soglia = soglia;
    }
    public int getSoglia() {
        return soglia;
    }



    public Corrispondenza check(String word1, Standard word2) {
        int[][] dp = new int[word1.length() + 1][word2.getValue().length() + 1];
       // System.out.println(" levenstein contronto "  + word1 + " con " + word2);

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.getValue().length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (word1.toLowerCase().charAt(i - 1) == word2.getValue().toLowerCase().charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = min(dp[i - 1][j - 1] + cost,  // sostituzione
                            dp[i - 1][j] + 1,         // eliminazione
                            dp[i][j - 1] + 1);        // inserimento
                }
            }
        }

        int distanza = dp[word1.length()][word2.getValue().length()];
      //  System.out.println( "distanza di lev tra " + word1 + " e " + word2 + " = " + distanza);
        if (distanza <= getSoglia()) {
            Corrispondenza corrispondenza = new Corrispondenza();
            corrispondenza.setStandard(word2);
            corrispondenza.setInput(word1);
            return corrispondenza;
        } else {
            return null;
        }
    }


    @Override
    public String getNameDetails(){
        return "-" + getSoglia();
    }


    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
    
    
    
  

  

  








