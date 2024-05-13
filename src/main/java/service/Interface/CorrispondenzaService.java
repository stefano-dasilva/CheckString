package service.Interface;

import Model.Corrispondenza;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public interface CorrispondenzaService {

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Corrispondenza approva(Corrispondenza corrispondenza) ;

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Corrispondenza add(Corrispondenza corrispondenza) ;

    @Transactional
    public Corrispondenza findByInput(String input);












}
