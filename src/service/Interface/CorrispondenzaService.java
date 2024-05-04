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
    public Corrispondenza ApprovaCorrispondeza(Corrispondenza corrispondeza) throws Exception;



}
