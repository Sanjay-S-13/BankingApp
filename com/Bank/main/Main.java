package com.Bank.main;

import com.Bank.entity.User;
import com.Bank.services.UserService;

import java.util.Scanner;

public class Main {
    static Scanner x = new Scanner(System.in);
    static Main main = new Main();

    static UserService obj = new UserService();

    public static void main(String[] args) {
        while (true) {
            Scanner x = new Scanner(System.in);
            System.out.println("Enter Your Name: ");
            String name = x.next();

            System.out.println("Enter Your Password: ");
            String pass = x.next();

            //System.out.println("Name: " + name + " Password: " + pass);

            //obj.printUsers();

            User user = obj.login(name, pass);
            if (user != null && user.getRole().equals("admin")) {
                main.adminWorkings();
            } else if (user != null && user.getRole().equals("user")) {
                main.UserWorkings(user.getName());
            } else {
                System.out.println("Id or Password is Incorrect");
            }
        }
    }
    private static void adminWorkings(){
        System.out.println("___Admin Account___");
        boolean flag = true;
        while(flag){
        System.out.println("1.logout/Signout");
        System.out.println("2.To Add New Customer");
        int n = x.nextInt();
        switch (n) {
            case 1:
                flag = false;
                break;
            case 2:
                main.AccountCreation();
                break;
            default:
                System.out.println("Wrong choice");
        }
        }
    }
    private static void UserWorkings(String name){
        System.out.println("___User Account___");
        boolean flag = true;
        while(flag) {
            System.out.println("1.logout/Signout");
            System.out.println("2.To Check Balance");
            int n = x.nextInt();
            switch (n) {
                case 1:
                    flag = false;
                    break;
                case 2:
                    Double balance = main.checkBankBalance(name);
                    System.out.println("Your Bank Balance is: "+balance);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    private static void AccountCreation(){
        System.out.println("Enter your Name: ");
        String name = x.next();
        System.out.println("Enter your Pass: ");
        String pass = x.next();
        System.out.println("Enter your Num: ");
        String num = x.next();
        boolean isit = obj.AccCreation(name,pass,num);
        if(isit){
            System.out.println("Account created Successfully");
        }
        else{
            System.out.println("Account cannot be created");
        }
    }
    private Double checkBankBalance(String name){
        return obj.checkBankBalance(name);
    }
}