package com.badorek.viikko_9_android;

import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage userStorage = null;

    private UserStorage(){

    }

    public static UserStorage getInstance() {
        if(userStorage == null){
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int id) {
        users.remove(id-1);

    }
}
