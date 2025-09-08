package com.Bank.services;

import com.Bank.entity.User;
import com.Bank.repository.UserRepo;

public class UserService {
    private UserRepo userobj = new UserRepo();

    public void printUsers(){
        userobj.printUsers();
    }
    public User login(String name, String pass){
        return userobj.login(name,pass);
    }
    public boolean AccCreation(String name,String pass,String number){
        return userobj.AccCreation(name,pass,number);
    }
    public Double checkBankBalance(String name){
        return userobj.checkBankBalance(name);
    }
}

