package com.example.Banderoll;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Question {
    @Setter
    @Getter
    private String rightAnswer;
    @Setter
    @Getter
    private String wrongAnswer1;
    @Setter
    @Getter
    private String wrongAnswer2;
    @Setter
    @Getter
    private String wrongAnswer3;
    private String[] answers = new String[4];
    @Getter
    String question;
    @Getter
    String correctAnswer;

    public Question(int typeOfQuestion) throws Exception {

        ApiController apicontroller = new ApiController();
        String[] questionCountries = apicontroller.getCountries();
        String[] questionFlags = apicontroller.getFlags();
        String[] questionCapitals = apicontroller.getCapitals();
        Random rand = new Random();
        int randomInt = rand.nextInt(questionCountries.length);
        Country country = new Country(questionCountries[randomInt], questionCapitals[randomInt], questionFlags[randomInt]);
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
        System.out.println(randomInt);
        arrayToString();
        randomizeAnswers();

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
