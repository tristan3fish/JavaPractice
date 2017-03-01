package com.tristan3fish.revision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Question {

    private int questionId;
	private String question;
	private String correctAnswer;
	private List<String> posibleAnswers;
	private List<Answer> attemptedAnswers;
	
	public Question(){}
	
	public Question(String qkey, String aValue, Collection<String> wrongAnswers, long seed) {
		question = qkey;
		correctAnswer = aValue;
		this.posibleAnswers = new ArrayList<String>(wrongAnswers);
		this.attemptedAnswers = new ArrayList<>();
		this.posibleAnswers.add(correctAnswer);
		Collections.shuffle(this.posibleAnswers, new Random(seed));
		this.setQuestionId(this.hashCode());
	}
	
	public Question(String qkey, String aValue, Collection<String> wrongAnswers){
		this(qkey, aValue, wrongAnswers, System.currentTimeMillis());
	}
	
	public boolean isCorrect(int userResponce) {
		return posibleAnswers.get(userResponce).equals(correctAnswer);
	}
	
	public String getCorrectAnswer(){
		return correctAnswer;
	}

	public void setQuestion(String question){
		this.question = question;
	}
	
	public String getQuestion(){
		return question;
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

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public List<Answer> getAttemptedAnswers() {
		return attemptedAnswers;
	}

	public void addAttempt(Answer a) {
		attemptedAnswers.add(a);
	}

	public List<String> getPosibleAnswers() {
		return posibleAnswers;
	}
}
