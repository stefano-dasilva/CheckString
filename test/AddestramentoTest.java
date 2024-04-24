import Algoritmi.LevhensteinCheckString;
import Algoritmi.MetaphoneCheckString;

public class AddestramentoTest {

    public static void main(String[] args) {

        LevhensteinCheckString levhensteinCheckString = new LevhensteinCheckString(2);
        LevhensteinCheckString levhensteinCheckString1 = new LevhensteinCheckString(3);
        levhensteinCheckString.setNext(levhensteinCheckString1);
        MetaphoneCheckString metaphoneCheckString = new MetaphoneCheckString();
        levhensteinCheckString1.setNext(metaphoneCheckString);
        levhensteinCheckString.check("philipppppine");

    }
    }
