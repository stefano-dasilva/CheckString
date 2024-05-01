package Dao.Interface;

import Model.Corrispondenza;
import org.springframework.transaction.annotation.Transactional;

public interface CorrispondenzaDao {


    @Transactional
    public Corrispondenza add(Corrispondenza corrispondenza);

    @Transactional
    public Corrispondenza findByInput(String input);

}
