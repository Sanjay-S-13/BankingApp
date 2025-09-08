package com.Bank.repository;

import com.Bank.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRepo {
    private static Set<User> userSet = new HashSet<>();

    static {
        User admin = new User("Admin","admin","12345","admin",0);
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
}
