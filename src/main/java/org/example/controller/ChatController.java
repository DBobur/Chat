package org.example.controller;
import org.example.model.Chat;
import org.example.model.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import static org.example.controller.Main.*;

public class ChatController {

    public static void createChat(){
        ArrayList<UUID> userIds = chatService.userChats(currentUser.getId());
        ArrayList<User> noContacts = userService.noContacts(userIds,currentUser.getId());
        if(noContacts.isEmpty()){
            System.out.println("Chat is empty");
            return;
        }
        showList(noContacts);
        int choice = scInt.nextInt()-1;
        User user = noContacts.get(choice);
        if (chatService.addModel(new Chat(currentUser.getId(),user.getId()))) {
            System.out.println("go on");
        }else{
            System.out.println("error");
        }
    }
    public static void myChats(){
        ArrayList<Chat> chats = chatService.userChatList(currentUser.getId());
        if (chats.isEmpty()) return;
        int i = 1;
        for (Chat chat : chats) {
            System.out.println(i++ + ". "+userService.getById(help1(chat,currentUser.getId())).getFullName());
        }
        System.out.print("Choice one: ");
        int choice = scInt.nextInt()-1;
        Chat chat = chats.get(choice);
        chatMenu(chat);
    }

    private static UUID help1(Chat chat, UUID id) {
        if(Objects.equals(chat.getFromUserId(),id)) return chat.getToUserId();
        return chat.getFromUserId();
    }
}
