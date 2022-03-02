package com.example.Banderoll;

import org.springframework.stereotype.Service;

@Service
public class Player {

    public String username;
    public String password;
    private int currentPoint;
    private int maxPoints; // get points from database
    private int lives = 3;

    public Player() {
    }

    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
        currentPoint = 0;

    }

    public void setUsername(String userName)  {
        this.userName = userName;
    }

    public void setPassword(String password)  {
        this.password = password;
    }

    public String getUserName()  {
        return userName;
    }

    public String getPassword()  {
        return password;
    }

    public void setPoint (){
        currentPoint++;
        if(currentPoint>maxPoints){
            maxPoints = currentPoint;
        }
    }
    public int getPoint (){
        return currentPoint;
    }
    public int getLives (){
        return lives;
    }
    public int getMaxPoints (){
        return currentPoint;
    }

    public boolean reduceAndCheckIfAlive(){
        if(lives<0){
            return false;
        }
        lives--;
        return true;

    }
}
