package Dao.Interface;

import Model.Algoritmo;
import Model.Corrispondenza;
import Model.Standard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StandardDao {

    @Transactional
    public Standard add(Standard  standard);

    @Transactional
    public List<Standard> getAll();

    @Transactional
    public Standard findById(Integer id);

    @Transactional
    public Standard findbyName(String nomepaese);

    @Transactional
    public Standard incrementaNumRicerche (String nomepaese);

}
