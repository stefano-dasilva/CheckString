package spring.web.Controller;

import Model.Utente;
import Model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.Interface.ChatService;
import service.Interface.UtenteService;
import spring.web.Message;
import org.springframework.ui.Model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class EsempioController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/prova")
    public String Prova(HttpServletRequest request, Model m) {

        HttpSession session = request.getSession(false);

        Utente u = (Utente) session.getAttribute("user");

        List<Chat> chats = chatService.findChatsFromUser(u);

        m.addAttribute("chats",chats);




        return "prova";
    }


    @MessageMapping("/chat/{chat_name}")
    @SendTo("/topic/messages/{chat_name}")
    public Message send(@DestinationVariable String chat_name, Message message) throws Exception {
        System.out.println("dentrochat");
        return message;
    }
}
