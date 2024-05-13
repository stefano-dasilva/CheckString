package Dao.Interface;

import Model.Corrispondenza;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CorrispondenzaDao {


   @Transactional
    public Corrispondenza create(Corrispondenza corrispondenza);

    @Transactional
    public Corrispondenza findByInput(String input);

    @Transactional
    public Corrispondenza update (Corrispondenza corrispondenza);

    @Transactional
    public List<Corrispondenza> findbyAlgorithm(String algorithm);






}
