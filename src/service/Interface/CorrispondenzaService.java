package service.Interface;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public interface CorrispondenzaService {

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public String ApprovaCorrispondeza(String corrispondeza) throws Exception;



}
