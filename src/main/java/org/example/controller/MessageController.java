package org.example.controller;
import org.example.model.Chat;
import org.example.model.Message;

import java.util.ArrayList;
import java.util.Objects;

import static org.example.controller.Main.*;

public class MessageController {
    public static void chatMessages(Chat chat){
        while (true) {
            ArrayList<Message> chatMessages = messageService.getChatMessages(chat.getId());
            showChatMessages(chatMessages);
            System.out.print("enter message(or -1 exit): ");
            String message = scStr.nextLine();
            if ("-1".equals(message)) return;
            messageService.addModel(new Message(currentUser.getId(),chat.getId(),message));
        }

    }

    private static void showChatMessages(ArrayList<Message> chatMessages) {
        for (Message chatMessage : chatMessages) {
            if(Objects.equals(chatMessage.getUserId(),currentUser.getId())){
                System.out.println("\t\t\t"+chatMessage.getMessage());
            }else{
                System.out.println(chatMessage.getMessage());
            }
        }
    }
}
