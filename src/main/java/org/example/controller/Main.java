package org.example.controller;

import org.example.model.BaseModel;
import org.example.model.Chat;
import org.example.model.User;
import org.example.service.ChatService;
import org.example.service.MessageService;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.controller.AuthController.*;
import static org.example.controller.ChatController.*;
import static org.example.controller.MessageController.*;

public class Main {
    public static Scanner scInt = new Scanner(System.in);
    public static Scanner scStr = new Scanner(System.in);

    public static UserService userService = new UserService();
    public static ChatService chatService = new ChatService();
    public static MessageService messageService = new MessageService();
    public static User currentUser;

    public static void main(String[] args) {
        while (true){
            System.out.println("1.Login\t2.Register\t0.Exit");
            System.out.print("enter command: ");
            int command = scInt.nextInt();
            switch (command){
                case 1 -> login();
                case 2 -> register();
                case 0 -> {return;}
            }
        }
    }

    public static void mainMenu(){
        while (true){
            System.out.println("1.Create Chat\t2.My Chats\t0.Logout");
            System.out.print("enter command: ");
            int command = scInt.nextInt();
            switch (command){
                case 1 -> createChat();
                case 2 -> myChats();
                case 0 -> {return;}
            }
        }
    }

    public static <T> void showList(ArrayList<T> list){
        int i = 1;
        for (T t : list) {
            System.out.println(i++ +". "+t);
        }
    }

    public static void chatMenu(Chat chat){
        chatMessages(chat);
    }
}
