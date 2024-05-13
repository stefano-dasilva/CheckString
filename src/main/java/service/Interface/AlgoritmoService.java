package service.Interface;

import Model.Algoritmo;
import Model.NonTrovata;
import Model.Standard;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AlgoritmoService {

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public Algoritmo setSuccesso(String nomeAlgoritmo, double percentualeSuccesso, double mediaTempo);

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public List<Algoritmo> getAll() ;

}
