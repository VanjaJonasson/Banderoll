package com.example.Banderoll;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class Question {

    private String rightAnswer;
    private String[] answers = new String[4];
    String question;
    String correctAnswer;
    int typeOfQuestion;
    //String[] questionCountries;
    //String[] questionFlags;
    //String[] questionCapitals;
    int index;
    //Autowired ApiController
    //@Autowired
    //private ApiController apicontroller;
    //@Autowired
    //CountryRepository repository;

    public Question() {
    }

    public Question(int typeOfQuestion) {
try {
    this.typeOfQuestion = typeOfQuestion;
    //apicontroller = new ApiController();
    assert repository != null;
    Country country = repository.findById(10L).get();


   // Random rand = new Random();
    long counter = repository.count();

    //index = rand.nextInt(questionCountries.length);
    //ThreadLocalRandom.current().nextInt(1,250);
    //Country country = new Country(questionCountries[index], questionCapitals[index], questionFlags[index]);
    Country rand1 = repository.findById((long) ThreadLocalRandom.current().nextInt(1, (int) counter)).get();
    Country rand2 = repository.findById((long) ThreadLocalRandom.current().nextInt(1, (int) counter)).get();
    Country rand3 = repository.findById((long) ThreadLocalRandom.current().nextInt(1, (int) counter)).get();

    switch (typeOfQuestion) {
        case 1:
            answers[0] = rand1.getName();
            answers[1] = rand2.getName();
            answers[2] = rand3.getName();
            answers[3] = country.getName();
            question = country.getFlag();
            correctAnswer = country.getName();
            break;
        case 2:
            answers[0] = rand1.getCapital();
            answers[1] = rand2.getCapital();
            answers[2] = rand3.getCapital();
            answers[3] = country.getCapital();
            question = country.getName();
            correctAnswer = country.getCapital();
            break;
        case 3:
            answers[0] = rand1.getFlag();
            answers[1] = rand2.getFlag();
            answers[2] = rand3.getFlag();
            answers[3] = country.getFlag();
            question = country.getName();
            correctAnswer = country.getFlag();
            break;
    }
    randomizeAnswers();
}catch (Exception e){
    e.printStackTrace();
}
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public int getIndex(){
        return index;
    }

    public boolean isCorrectAnswer(int typeOfQuestion, int index, String playerAnswer) {

        if (typeOfQuestion == 1) {
            if (repository.findById((long) index).get().getName().equals(playerAnswer)) {
                return true;
            }
        }
        else if (typeOfQuestion == 2) {
            if (repository.findById((long)index).get().getCapital().equals(playerAnswer)) {
                return true;
            }
        }
        else if (typeOfQuestion == 3) {
            if (repository.findById((long)index).get().getFlag().equals(playerAnswer)) {
                    return true;
            }
        }
            return false;
    }


    private void randomizeAnswers() {
        for (int i = 0; i < answers.length; i++) {
            Random rand = new Random();
            int randomInt = rand.nextInt(answers.length - 1);
            String tempAnswer = answers[i];
            answers[i] = answers[randomInt];
            answers[randomInt] = tempAnswer;
        }
    }
    public void arrayToString() {
        System.out.println(Arrays.toString(answers));
        System.out.println(question);
    }
}
