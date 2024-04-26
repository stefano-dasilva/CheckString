import Algoritmi.JaccardCheckString;
import Algoritmi.LevhensteinCheckString;

public class JaccardTest {
    public static void main(String[] args) {
        /*
        JaccardCheckString jaccardCheckString = new JaccardCheckString(0.8);
        jaccardCheckString.check("brasil","Brasile");

         */
        LevhensteinCheckString levhensteinCheckString = new LevhensteinCheckString(2);
        levhensteinCheckString.check("brasil","Brasile");

    }
    }
