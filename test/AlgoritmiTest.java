import Algoritmi.JaccardCheckString;
import Model.Corrispondenza;
import Model.Standard;

public class AlgoritmiTest {
    public static void main(String[] args) {
        System.out.println("prova");
        JaccardCheckString jaccardCheckString = new JaccardCheckString(0.75);
        Standard standard = new Standard();
        standard.setValue("Brasile");
        Corrispondenza corrispondenza = jaccardCheckString.check("brasile",standard);
        if(corrispondenza!= null){
            System.out.println("trovata");
        }
    }
}
