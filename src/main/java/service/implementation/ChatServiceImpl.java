package service.implementation;

import Dao.Interface.ChatDao;
import Model.Chat;
import Model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import service.Interface.ChatService;

import java.util.ArrayList;
import java.util.List;

public class ChatServiceImpl  implements ChatService {


    @Autowired
    ChatDao chatDao;


    @Override
    public List<Chat> findChatsFromUser(Utente utente) {
        return chatDao.findChatsByUser(utente);
    }
}
