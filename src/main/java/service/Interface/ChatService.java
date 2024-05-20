package service.Interface;

import Model.Chat;
import Model.Utente;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface ChatService {

    @Transactional(
            rollbackFor = {Throwable.class, Exception.class},
            propagation = Propagation.NESTED,
            isolation = Isolation.READ_UNCOMMITTED)
    public List<Chat> findChatsFromUser(Utente utente) ;
}
