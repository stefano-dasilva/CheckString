package service.Interface;

import Model.NonTrovata;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface NonTrovatoService {

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public NonTrovata inserisciNonTrovato(NonTrovata nonTrovata) throws Exception;

}
