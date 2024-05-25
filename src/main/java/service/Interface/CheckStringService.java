package service.Interface;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface CheckStringService {

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_UNCOMMITTED)
    public String check(String nazione) ;

}
