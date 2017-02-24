package com.tristan3fish.revision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.StringJoiner;

public class Question {

    private int questionId;
	private String question;
	private String correctAnswer;
	private ArrayList<String> posibleAnswers;
	
	public Question(String qkey, String aValue, Collection<String> wrongAnswers, long seed) {
		question = qkey;
		correctAnswer = aValue;
		this.posibleAnswers = new ArrayList<String>(wrongAnswers);
		this.posibleAnswers.add(correctAnswer);
		Collections.shuffle(this.posibleAnswers, new Random(seed));
	}
	
	public Question(String qkey, String aValue, Collection<String> wrongAnswers){
		this(qkey, aValue, wrongAnswers, System.currentTimeMillis());
	}
	
	public void print(){
		System.out.println(question+":");
		StringJoiner sj = new StringJoiner(System.lineSeparator() + "\t", "\t", "");
		for(String awnswer: posibleAnswers){
			sj.add(awnswer);
		}
		System.out.println(sj.toString());
	}
	
	public String getShortString(){
		StringJoiner sj = new StringJoiner(", ");
		for(String awnswer: posibleAnswers){
			sj.add(awnswer);
		}
		return question+":"+sj.toString();
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
}
