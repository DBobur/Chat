package org.example.service;

import org.example.model.Message;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class MessageService extends BaseService<Message> {
    {
        PATH += "/messages.json";
    }
    @Override
    protected boolean hasModel(Message message) {
        return false;
    }

    @Override
    protected Class<Message> getType() {
        return Message.class;
    }

    public ArrayList<Message> getChatMessages(UUID id) {
        ArrayList<Message> chatMessages = new ArrayList<>();
        for (Message message : readAll()) {
            if(Objects.equals(message.getChatId(),id)) chatMessages.add(message);
        }
        return chatMessages;
    }
}
