package com.example.Banderoll;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Question {

    private String question;
    private String[] answers = new String[4];
    private String correctAnswer;

    public Question(){

    }

    public String getRightAnswer() {
        return correctAnswer;
    }
    public String getQuestion() {
        return question;
    }
    public void setRightAnswer(String answer){
        correctAnswer = answer;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public String[] getAnswers() {
        return answers;
    }

    public void randomizeAnswers() {
        for (int i = 0; i < answers.length; i++) {
            Random rand = new Random();
            int randomInt = rand.nextInt(answers.length - 1);
            String tempAnswer = answers[i];
            answers[i] = answers[randomInt];
            answers[randomInt] = tempAnswer;
        }
    }

}
