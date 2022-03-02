package com.example.Banderoll;


import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

@Service
public class Question {

    private String rightAnswer;
    private String[] answers = new String[4];
    String question;
    String correctAnswer;
    int typeOfQuestion;
    String[] questionCountries;
    String[] questionFlags;
    String[] questionCapitals;
    int index;
    private static ApiController apicontroller;

    public Question() {
    }

    public Question(int typeOfQuestion) {
try {
    this.typeOfQuestion = typeOfQuestion;
    apicontroller = new ApiController();
    questionCountries = apicontroller.getCountries();
    questionFlags = apicontroller.getFlags();
    questionCapitals = apicontroller.getCapitals();


    Random rand = new Random();
    index = rand.nextInt(questionCountries.length);
    Country country = new Country(questionCountries[index], questionCapitals[index], questionFlags[index]);
    int rand1 = rand.nextInt(questionCountries.length);
    int rand2 = rand.nextInt(questionCountries.length);
    int rand3 = rand.nextInt(questionCountries.length);
    switch (typeOfQuestion) {
        case 1:
            answers[0] = questionCountries[rand1];
            answers[1] = questionCountries[rand2];
            answers[2] = questionCountries[rand3];
            answers[3] = country.getName();
            question = country.getFlag();
            correctAnswer = country.getName();
            break;
        case 2:
            answers[0] = questionCapitals[rand1];
            answers[1] = questionCapitals[rand2];
            answers[2] = questionCapitals[rand3];
            answers[3] = country.getCapital();
            question = country.getName();
            correctAnswer = country.getCapital();
            break;
        case 3:
            answers[0] = questionFlags[rand1];
            answers[1] = questionFlags[rand2];
            answers[2] = questionFlags[rand3];
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

    public static boolean isCorrectAnswer(int typeOfQuestion, int index, String playerAnswer) {

        if (typeOfQuestion == 1) {
            System.out.println(apicontroller.getCountries()[index]);
            System.out.println(playerAnswer);
            if (apicontroller.getCountries()[index].equals(playerAnswer)) {
                return true;
            }
        }
        else if (typeOfQuestion == 2) {
            if (apicontroller.getCapitals()[index].equals(playerAnswer)) {
                return true;
            }
        }
        else if (typeOfQuestion == 3) {
            if (apicontroller.getFlags()[index].equals(playerAnswer)) {
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
