package com.example.Banderoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class QuestionService {

    private String[] answers = new String[4];

    @Autowired
    CountryRepository repository;

    public QuestionService() {

    }

    public Question getQuestion(int choice) {
        Question q = new Question();
        Country[] countries = new Country[4];
        try {

            //ibland får vi 0 i svar?
            long counter = repository.count();
            System.out.println("Counter: "+counter);

            Country rand1 = repository.findById((long) ThreadLocalRandom.current().nextInt(1, (int) counter)).get();
            Country rand2 = repository.findById((long) ThreadLocalRandom.current().nextInt(1, (int) counter)).get();
            Country rand3 = repository.findById((long) ThreadLocalRandom.current().nextInt(1, (int) counter)).get();
            Country country = repository.findById((long) ThreadLocalRandom.current().nextInt(1, (int) counter)).get();

            countries[0] = country;
            countries[1] = rand1;
            countries[2] = rand2;
            countries[3] = rand3;

            switch (choice) {
                case 1:
                    answers[0] = countries[0].getName();
                    answers[1] = countries[1].getName();
                    answers[2] = countries[2].getName();
                    answers[3] = countries[3].getName();
                    q.setAnswers(answers);
                    q.setRightAnswer(answers[0]);
                    q.setQuestion(countries[0].getFlag());

                    break;
                case 2:
                    answers[0] = countries[0].getCapital();
                    answers[1] = countries[1].getCapital();
                    answers[2] = countries[2].getCapital();
                    answers[3] = countries[3].getCapital();
                    q.setAnswers(answers);
                    q.setRightAnswer(answers[0]);
                    q.setQuestion(countries[0].getName());
                    break;
                case 3:
                    answers[0] = countries[0].getFlag();
                    answers[1] = countries[1].getFlag();
                    answers[2] = countries[2].getFlag();
                    answers[3] = countries[3].getFlag();
                    q.setAnswers(answers);
                    q.setRightAnswer(answers[0]);
                    q.setQuestion(countries[0].getName());
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        q.randomizeAnswers();
        return q;
    }
}

   /*
   public Question getCountries(){
        return new Question(1);
   }
    public Question getCapitals(){
        return new Question(2);
    }
    public Question getFlags(){
        return new Question(3);
    }
}
*/