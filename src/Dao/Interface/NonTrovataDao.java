package Dao.Interface;

import Model.Corrispondenza;
import Model.NonTrovata;
import org.springframework.transaction.annotation.Transactional;

public interface NonTrovataDao {

    @Transactional
    public NonTrovata add(NonTrovata nonTrovata);

    @Transactional
    public NonTrovata findByInput(String input);
}
