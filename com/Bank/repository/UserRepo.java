package com.Bank.repository;

import com.Bank.entity.Transactions;
import com.Bank.entity.User;
import com.Bank.services.UserService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class UserRepo {
    private static Set<User> userSet = new HashSet<>();
    private static List<Transactions> transactionsList = new ArrayList<>();
    Map<String , Boolean> chequeList = new HashMap<>();

    static {
        User admin = new User("admin","admin","12345","admin",0);
        User user1 = new User("s","s","13","user",10000);
        User user2 = new User("d","d","29","user",20000);
        User user3 = new User("r","r","1","user",30000);
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
        boolean isdebit = debit(payeeName,amount,recName);
        boolean iscredit = credit(recName,amount,payeeName);
        return isdebit && iscredit;

    }
    public boolean debit(String payeeName,Double amount , String recName){
        User user = getUser(payeeName);
        Double accBalance = user.getBalance();
        userSet.remove(user);
        Double finalBalance = accBalance-amount;
        user.setBalance(finalBalance);

        Transactions transaction = new Transactions(
                LocalDate.now(),
                payeeName,
                recName,
                accBalance,
                finalBalance
                );
        transactionsList.add(transaction);
        return userSet.add(user);
    }
    public boolean credit(String recName,Double amount,String PayeeName){
        User user = getUser(recName);
        Double accBalance = user.getBalance();
        userSet.remove(user);
        Double finalBalance = accBalance+amount;
        user.setBalance(finalBalance);
        Transactions transaction = new Transactions(
                LocalDate.now(),
                recName,
                PayeeName,
                accBalance,
                finalBalance
        );
        transactionsList.add(transaction);
        return userSet.add(user);
    }

    public void toPrintTransactionHistory(String name){
        List<Transactions> UserTransaction = transactionsList.stream()
                .filter(transactions -> transactions.getTransactionUserId().equals(name))
                .collect(Collectors.toList());

        for (Transactions t:UserTransaction){
            System.out.println("Date\t\tUserID\t\tBefore Amount\tFinal Amount");
            System.out.println("----------------------------------------------------");
            System.out.println(t.getTransactionDate()
                    + "\t" + t.getTransactionUserId()
                    + "\t" + t.getBeforeAmount()
                    + "\t\t" + t.getFinalAmount());
            System.out.println("----------------------------------------------------");
        }
    }
    public void applyingChequeBook(String name){
            chequeList.put(name,false);
    }
    public Map<String,Boolean> getAllapplyingChequeBook(String name){
        return chequeList;
    }
    public List<String> getChequeBookLists(){
        List<String> userIds = new ArrayList<>();
        for(Map.Entry<String,Boolean>entry : chequeList.entrySet()){
            if(!entry.getValue()){
                userIds.add(entry.getKey());
            }
        }
        return userIds;
    }
    public void approvalOfCheque(String name) {
        if (chequeList.containsKey(name)) {
            chequeList.put(name,true);
        }
    }
}