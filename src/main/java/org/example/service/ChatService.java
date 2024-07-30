package org.example.service;

import org.example.model.Chat;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class ChatService extends BaseService<Chat> {
    {
        PATH += "/chats.json";
    }
    @Override
    protected boolean hasModel(Chat chat) {
        return false;
    }

    @Override
    protected Class<Chat> getType() {
        return Chat.class;
    }

    public ArrayList<UUID> userChats(UUID id) {
        ArrayList<UUID> userIds = new ArrayList<>();
        for (Chat chat : readAll()) {
            if(Objects.equals(chat.getToUserId(),id)){
                userIds.add(chat.getFromUserId());
            }else if (Objects.equals(chat.getFromUserId(),id)){
                userIds.add(chat.getToUserId());
            }
        }
        return userIds;
    }

    public ArrayList<Chat> userChatList(UUID id) {
        ArrayList<Chat> userChats = new ArrayList<>();
        for (Chat chat : readAll()) {
            if(Objects.equals(chat.getToUserId(),id)){
                userChats.add(chat);
            }else if (Objects.equals(chat.getFromUserId(),id)){
                userChats.add(chat);
            }
        }
        return userChats;
    }
}
