package com.Bank.repository;

import com.Bank.entity.User;
import com.Bank.services.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRepo {
    private static Set<User> userSet = new HashSet<>();

    static {
        User admin = new User("admin","admin","12345","admin",0);
        User user1 = new User("user1","user1","12344","user",1000);
        User user2 = new User("user2","user2","123456","user",2000);
        User user3 = new User("user2","user2","123456","user",2000);
        userSet.add(admin);
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);
    }

    public void printUsers(){
        System.out.println(userSet);
    }

    public User login(String name , String pass){
       List<User> finalList = userSet.stream()
               .filter(user -> user.getName().equals(name) && user.getPassword().equals(pass))
               .collect(Collectors.toList());

       if(!finalList.isEmpty()){
           return finalList.get(0);
       }
       else{
           return null;
       }
    }
    public boolean AccCreation(String name,String pass,String number){
        User user = new User(name,pass,number,"user",500);
        return userSet.add(user);
    }
    public Double checkBankBalance(String username){
        List<User> finalList = userSet.stream()
                .filter(user -> user.getName().equals(username))
                .collect(Collectors.toList());

        if(!finalList.isEmpty()){
            return finalList.get(0).getBalance();
        }
        else{
            return null;
        }
    }

    public User getUser(String userid){
        List<User> userResult = userSet.stream()
                .filter(user -> user.getName().equals(userid))
                .collect(Collectors.toList());

        if(!userResult.isEmpty()){
            return userResult.get(0);
        }
        return null;
    }

    public boolean moneyTransfer(String payeeName , String recName , Double amount){
        boolean isdebit = debit(payeeName,amount);
        boolean iscredit = credit(recName,amount);
        return isdebit && iscredit;

    }
    public boolean debit(String payeeName,Double amount){
        User user = getUser(payeeName);
        Double accBalance = user.getBalance();
        userSet.remove(user);
        Double finalBalance = accBalance-amount;
        user.setBalance(finalBalance);
        return userSet.add(user);
    }
    public boolean credit(String RecName,Double amount){
        User user = getUser(RecName);
        Double accBalance = user.getBalance();
        userSet.remove(user);
        Double finalBalance = accBalance+amount;
        user.setBalance(finalBalance);
        return userSet.add(user);
    }
}