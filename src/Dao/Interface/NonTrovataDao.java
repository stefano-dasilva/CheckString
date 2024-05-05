package Dao.Interface;

import Model.Corrispondenza;
import Model.NonTrovata;
import org.springframework.transaction.annotation.Transactional;

public interface NonTrovataDao {

    @Transactional
    public NonTrovata create(NonTrovata nonTrovata);

    @Transactional
    public NonTrovata findByInput(String input);

    @Transactional
    public NonTrovata update(NonTrovata nonTrovata);

    @Transactional
    public NonTrovata delete(NonTrovata nonTrovata);
}
