package org.example.controller;
import org.example.model.User;

import static org.example.controller.Main.*;

public class AuthController {
    public static void login(){
        System.out.print("enter username: ");
        String username = scStr.nextLine();
        System.out.print("enter password: ");
        String password = scStr.nextLine();
        currentUser = userService.login(username, password);
        if(currentUser == null) System.out.println("user not found");
        else{
            System.out.println("welcome "+currentUser.getFullName()+"!");
            mainMenu();
        }
    }
    public static void register(){
        System.out.print("enter full name: ");
        String fullName = scStr.nextLine();
        System.out.print("enter username: ");
        String username = scStr.nextLine();
        System.out.print("enter password: ");
        String password = scStr.nextLine();
        if (userService.addModel(new User(fullName,username,password))) {
            System.out.println("registered successfully");
        }else {
            System.out.println("user already exist");
        }
    }
}
