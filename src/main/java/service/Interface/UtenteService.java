package service.Interface;

import spring.web.dto.UtenteClassifica;
import spring.web.vo.Filter.ClassificaFilter;
import Model.Utente;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UtenteService {

  /*  @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente inserisciUtente(Utente utente) throws NoSuchAlgorithmException;
*/
  @Transactional(
          rollbackFor = {Throwable.class, Exception.class},
          propagation = Propagation.REQUIRED)
  public Utente inserisciUtente(Utente utente) throws NoSuchAlgorithmException;


    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente rimuoviUtente(Utente utente);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente cambiaPassword(Utente utente, String password);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente findByUsername(String username);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente caricaImmagine(byte[] img, Utente utente);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Utente rimuoviImg(Utente utente, byte[] bytes);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    Utente updateDati(Utente u, Utente u1);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public boolean setRecordBandiere(Utente utente, int num_bandiere);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public boolean setRecordCapitali(Utente utente, int num_capitali);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public boolean setRecordPopolazione(Utente utente, int num_popolazione);


    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public List<UtenteClassifica> showClassifica(ClassificaFilter filter) throws IOException;








}
