package service.Interface;

import Model.Utente;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

public interface UtenteService {

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente inserisciUtente(Utente utente) throws NoSuchAlgorithmException;


    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente rimuoviUtente(Utente utente);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente cambiaPassword(Utente utente, String password);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente findByUsername(String username);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente addFriend(Utente utente, String username);




}
