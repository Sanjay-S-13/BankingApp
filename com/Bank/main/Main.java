package com.Bank.main;

import com.Bank.entity.User;
import com.Bank.repository.UserRepo;
import com.Bank.services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String name = x.next();

        System.out.println("Enter Your Password: ");
        String pass = x.next();

        System.out.println("Name: "+name +" Password: "+pass);

        UserService obj = new UserService();
        obj.printUsers();

        User user = obj.login(name,pass);
        if(user!=null){
            System.out.println("Successfully Login");
        }
        else{
            System.out.println("Id or Password is Incorrect");
        }

    }
}
