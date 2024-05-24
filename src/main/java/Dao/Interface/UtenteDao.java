package Dao.Interface;

import Filter.ClassificaFilter;
import Model.Standard;
import Model.Utente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UtenteDao {

    @Transactional
    public Utente create(Utente utente);

    @Transactional
    public Utente delete(Utente utente);

    @Transactional
    public Utente findByUsername(String username);

    @Transactional
    public List<Utente> getAll();

    @Transactional
    public void cambiaPassword(Utente utente, String nuovaPassword);

    @Transactional
    public Utente update(Utente standard);

   @Transactional
    public Utente removeImg(Utente utente);
   @Transactional
    public Utente updateDati(Utente u, Utente u1);


    @Transactional
    public List<Utente> getClassifica(ClassificaFilter filter);


}