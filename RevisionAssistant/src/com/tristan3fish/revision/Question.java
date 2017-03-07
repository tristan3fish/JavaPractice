package com.tristan3fish.revision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class Question {

    private int questionId;
	private String question;
	private String correctAnswer;
	private List<String> posibleAnswers;
	private Set<Answer> attemptedAnswers;
	
	public Question(){}
	
	public Question(String question, String correctAnswer, List<String> posibleAnswers) {//, long seed
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.posibleAnswers = posibleAnswers;
		this.posibleAnswers.add(correctAnswer);
		this.attemptedAnswers = new HashSet<>();
		this.setQuestionId(this.hashCode());
	}
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public void setQuestion(String question){
		this.question = question;
	}
	
	public String getCorrectAnswer(){
		return correctAnswer;
	}
	
	public void setCorrectAnswer(String correctAnswer){
		this.correctAnswer = correctAnswer;
	}

	public List<String> getPosibleAnswers() {
		return posibleAnswers;
	}
	
	public void setPosibleAnswers(List<String> posibleAnswers) {
		this.posibleAnswers = posibleAnswers;
	}
	
	public Set<Answer> getAttemptedAnswers() {
		return attemptedAnswers;
	}
	
	public void setAttemptedAnswers(Set<Answer> attemptedAnswers) {
		this.attemptedAnswers = attemptedAnswers;
	}
	
	@Override
	public int hashCode(){
	    return Objects.hash(question, correctAnswer, posibleAnswers);
	}
	
	@Override
	public boolean equals(Object o)
	{
	    return hashCode() == o.hashCode();
	}
	
	public boolean isCorrect(int userResponce) {
		return posibleAnswers.get(userResponce).equals(correctAnswer);
	}
	
	public void addAttempt(Answer a) {
		attemptedAnswers.add(a);
	}
}
