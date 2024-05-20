package Dao.Interface;

import Model.Standard;
import Model.Utente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UtenteDao {

    @Transactional
    public Utente create(Utente utente);

    @Transactional
    public Utente update(Utente utente);

    @Transactional
    public Utente delete(Utente utente);

    @Transactional
    public Utente findByUsername(String username);

    @Transactional
    public List<Utente> getAll();



    @Transactional
    public void cambiaPassword(Utente utente, String nuovaPassword);

}
