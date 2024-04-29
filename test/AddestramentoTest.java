import Addestramento.Addestramento;
import Assets.DBmock;

public class AddestramentoTest {

    public static void main(String[] args) {


       Addestramento addestramento = new Addestramento();
        addestramento.addestra();
        DBmock.getIstanza().statistiche();
       // addestramento.printMap();

    }
    }
