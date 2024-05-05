import Addestramento.Addestramento;
import Model.Algoritmo;

import java.util.List;

public class AddestramentoTest {

    public static void main(String[] args) {


       Addestramento addestramento = Addestramento.getIstanza();
        addestramento.addestra();

       List<Algoritmo> algoritmi = addestramento.stampaClassifica();
       for( Algoritmo algoritmo : algoritmi){
           System.out.println("Nome : " + algoritmo.getNome() + "Percentuale successo : " + algoritmo.getSuccesso() + "Media tempo successo : " + algoritmo.getMediaTempo());
       }

    }
    }
