package com.example.Banderoll;

import org.springframework.stereotype.Service;

@Service
public class Player {

    public String username;
    public String password;

    public Player() {
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;


    }



    public void setUsername(String username)  {
        this.username = username;
    }

    public void setPassword(String password)  {
        this.password = password;
    }

    public String getUsername()  {
        return username;
    }

    public String getPassword()  {
        return password;
    }
}
