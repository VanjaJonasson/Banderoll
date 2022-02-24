package com.example.Banderoll;

import lombok.Getter;
import lombok.Setter;

public class Question {
    @Getter
    @Setter
    private String poseQuestion;
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

    public Question(String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        this.rightAnswer = rightAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
    }
}
