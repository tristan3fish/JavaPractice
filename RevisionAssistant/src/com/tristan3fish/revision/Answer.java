package com.tristan3fish.revision;

import java.util.Date;
import java.util.Objects;

public class Answer {
	
	private int answerId;	
	private Date timeCreated;
	private int answer;
	private boolean correct;
	private long hesitation_ms;
	private Question question;

	public Answer(){}
	
	public Answer(Date timeCreated, int answer, boolean correct, long hesitation_ms){ //Question question, 
		this.timeCreated = timeCreated;
		this.answer = answer;
		this.correct = correct;
		//this.question = question;
		this.hesitation_ms = hesitation_ms;
		this.setAnswerId(this.hashCode());
	}
	
	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	public Date getTimeCreated() {
		return timeCreated;
	}
	
	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}
	
	public int getAnswer() {
		return answer;
	}
	
	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public boolean isCorrect() {
		return correct;
	}
	
	public void setCorrect(boolean isCorrect) {
		this.correct = isCorrect;
	}

	public long getHesitation_ms() {
		return hesitation_ms;
	}

	public void setHesitation_ms(long hesitation_ms) {
		this.hesitation_ms = hesitation_ms;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public void setQuestion(Question question) {
		this.question = question ;
	}
	
	public double getHesitation_s() {
		return (double) hesitation_ms / 1000d;
	}
	
	@Override
	public int hashCode(){
	    return Objects.hash(timeCreated, answer, correct);//, question.hashCode());
	}

}
