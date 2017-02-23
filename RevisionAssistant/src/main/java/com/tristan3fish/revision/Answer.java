package com.tristan3fish.revision;

import java.util.Date;
import java.util.Objects;

public class Answer {
	
	private Date dateTime;
	private int ans;
	private boolean isCorrect;
	private Question q;
	private long hesitation_ms;
	
	public Answer(int ans, Question q, long hesitation_ms){
		this.dateTime = new Date();
		this.ans = ans;
		this.isCorrect = q.isCorrect(ans);
		this.q = q;
		this.hesitation_ms = hesitation_ms;
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
	
	public long getHesitation_ms() {
		return hesitation_ms;
	}
	
	public double getHesitation_s() {
		return (double) hesitation_ms / 1000d;
	}
	
	@Override
	public int hashCode(){
	    return Objects.hash(dateTime, ans, isCorrect, q.hashCode());
	}
}
