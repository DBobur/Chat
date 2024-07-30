package org.example.service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class UserService extends BaseService<User> {
    {
        PATH += "/users.json";
    }
    @Override
    protected boolean hasModel(User user) {
        return false;
    }

    @Override
    protected Class<User> getType() {
        return User.class;
    }

    public User login(String username, String password){
        for (User user : readAll()) {
            if(Objects.equals(user.getUsername(),username) &&
               Objects.equals(user.getPassword(),password)) return user;
        }
        return null;
    }

    public ArrayList<User> noContacts(ArrayList<UUID> userIds, UUID id) {
        ArrayList<User> noContacts = new ArrayList<>();
        for (User user : readAll()) {
            if(checkContact(userIds,user.getId()) &&
               !Objects.equals(user.getId(),id)) noContacts.add(user);
        }
        return noContacts;
    }

    private boolean checkContact(ArrayList<UUID> userIds, UUID  id) {
        for (UUID userId : userIds) {
            if(Objects.equals(userId,id)) return false;
        }
        return true;
    }
}
