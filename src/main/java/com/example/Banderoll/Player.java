package com.example.Banderoll;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username")
    public String userName;
    public String password;
    @Column(name="currentpoint")
    private int currentPoint;
    @Column(name="maxpoints")
    private int maxPoints; // get points from database
    private int lives = 3;

    @Transient
    private String latestAnswer;
    @Transient
    private int questionsAnswered;
    @Transient
    private List<String> wrongAnswers = new ArrayList<>();

    public Player() {
    }

    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
        currentPoint = 0;

    }

    public void clearWrongAnswers() {
        wrongAnswers.clear();
    }

    public void saveWrongAnswers(String w) {
        wrongAnswers.add(w);
        System.out.println(wrongAnswers.size());
        System.out.println(w);
    }

    public List getwrongAnswers()   {
        return wrongAnswers;
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

    public int getQuestionsAnswered() {
        return questionsAnswered;
    }
    public void setQuestionsAnswered(int questionsAnswered) {
        this.questionsAnswered = questionsAnswered;
    }

    public boolean reduceAndCheckIfAlive(){
        if(lives<1){
            return false;
        }
        lives--;
        return true;

    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setLatestAnswer(String answer){
        latestAnswer = answer;
    }
    public String getLatestAnswer(){
        return latestAnswer;
    }

}
