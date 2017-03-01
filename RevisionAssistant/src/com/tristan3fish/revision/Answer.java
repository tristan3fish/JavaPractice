package com.tristan3fish.revision;

import java.util.Date;
import java.util.Objects;

public class Answer {
	
	private Date dateTime;
	private int answer;
	private boolean isCorrect;
	private Question question;
	private long hesitation_ms;
	private int answerId;
	
	public Answer(){}
	
	public Answer(int ans, Question q, long hesitation_ms){
		this.dateTime = new Date();
		this.answer = ans;
		this.isCorrect = q.isCorrect(ans);
		this.question = q;
		this.hesitation_ms = hesitation_ms;
		this.setAnswerId(this.hashCode());
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public int getAnswer() {
		return answer;
	}
	
	public boolean isCorrect() {
		return isCorrect;
	}
	
	public Question getQuestion() {
		return question;
	}

	public Date getDateTime() {
		return dateTime;
	}
	
	public long getHesitation_ms() {
		return hesitation_ms;
	}
	
	public double getHesitation_s() {
		return (double) hesitation_ms / 1000d;
	}
	
	@Override
	public int hashCode(){
	    return Objects.hash(dateTime, answer, isCorrect, question.hashCode());
	}
	
	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
}
