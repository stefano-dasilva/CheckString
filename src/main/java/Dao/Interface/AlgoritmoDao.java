package Dao.Interface;

import Model.Algoritmo;
import Model.Corrispondenza;
import Model.Standard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AlgoritmoDao {

    @Transactional
    public Algoritmo update (Algoritmo algoritmo);

    @Transactional
    public List<Algoritmo> getAll();

    @Transactional
    public Algoritmo create(Algoritmo algoritmo);


    @Transactional
    public Algoritmo findByInputAlg(String nomealgoritmo);


}
