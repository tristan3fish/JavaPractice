package com.tristan3fish.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {

    private int questionId;
	private String question;
	private String correctAnswer;
	private List<String> posibleAnswers;
	private List<Answer> attemptedAnswers;
	
	public Question(){}
	
	public Question(String question, String correctAnswer, List<String> posibleAnswers) {//, long seed
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.posibleAnswers = posibleAnswers;
		this.attemptedAnswers = new ArrayList<>();
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
	
	public List<Answer> getAttemptedAnswers() {
		return attemptedAnswers;
	}
	
	public void setAttemptedAnswers(List<Answer> attemptedAnswers) {
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
		a.setQuestion(this);
		attemptedAnswers.add(a);
	}
}
