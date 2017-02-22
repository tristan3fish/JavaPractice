package com.tristan3fish.revision;

import java.util.Date;
import java.util.Objects;

public class Answer {
	
	private Date dateTime;
	private int ans;
	private boolean isCorrect;
	private Question q;
	
	public Answer(int ans, boolean isCorrect, Question q){
		this.dateTime = new Date();
		this.ans = ans;
		this.isCorrect = isCorrect;
		this.q = q;
	}
	
	public int getAns() {
		return ans;
	}
	
	public boolean isCorrect() {
		return isCorrect;
	}
	
	public Question getQ() {
		return q;
	}

	public Date getDateTime() {
		return dateTime;
	}
	
	@Override
	public int hashCode(){
	    return Objects.hash(dateTime, ans, isCorrect, q.hashCode());
	}
}
