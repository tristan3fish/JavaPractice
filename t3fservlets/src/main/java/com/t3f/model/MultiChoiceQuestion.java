package com.t3f.model;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiChoiceQuestion {
    private String question;
    private String correctAnswer;
    private String[] nonValidAnswers;
    private String[] allPossibleAnswers;

    public MultiChoiceQuestion(String question, String correctAnswer, String[] nonValidAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.nonValidAnswers = nonValidAnswers;

        this.allPossibleAnswers = ArrayUtils.addAll(
                new String[] {this.correctAnswer},
                this.nonValidAnswers
        );
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getNonValidAnswers() {
        return nonValidAnswers;
    }

    public List<String> getAllPossibleAnswersShuffled() {
        List<String> allAnswers = Arrays.asList(allPossibleAnswers);
        Collections.shuffle(allAnswers);
        return allAnswers;
    }

    public Boolean isCorrectAnswer(String proposedAnswer) {
        return correctAnswer.equals(proposedAnswer);
    }
}
