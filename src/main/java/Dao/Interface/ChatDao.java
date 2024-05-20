package Dao.Interface;

import Model.Chat;
import Model.Corrispondenza;
import Model.Utente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChatDao {

    @Transactional
    public List<Chat> findChatsByUser(Utente utente);
}
