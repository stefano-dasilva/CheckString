package Algoritmi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class LevhensteinCheckString extends CheckString {
    private int soglia;

    public LevhensteinCheckString(int soglia) {
        this.soglia = soglia;
    }
    public int getSoglia() {
        return soglia;
    }



    public boolean check(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (word1.toLowerCase().charAt(i - 1) == word2.toLowerCase().charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = min(dp[i - 1][j - 1] + cost,  // sostituzione
                            dp[i - 1][j] + 1,         // eliminazione
                            dp[i][j - 1] + 1);        // inserimento
                }
            }
        }

        int distanza = dp[word1.length()][word2.length()];
        System.out.println(distanza);
        if (distanza <= getSoglia()) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String getName(){
        return super.getName()+getSoglia();
    }


    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
    
    
    
  

  

  








