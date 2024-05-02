package Dao.Interface;

import Model.Algoritmo;
import Model.Corrispondenza;
import org.springframework.transaction.annotation.Transactional;


public interface AlgoritmoDao {

    @Transactional
    public Algoritmo incrementaSucceso (String nome);

    @Transactional
    public Algoritmo findByInputAlg(String nomealgoritmo);


}
