import Algoritmi.JaccardCheckString;
import Algoritmi.LevhensteinCheckString;

public class JaccardTest {
    public static void main(String[] args) {

        JaccardCheckString jaccardCheckString = new JaccardCheckString(0.8);
        System.out.println(jaccardCheckString.check("repubblica ","repubblica ceca"));


        LevhensteinCheckString levhensteinCheckString = new LevhensteinCheckString(2);
        levhensteinCheckString.check("iran","iraq");

    }
    }
