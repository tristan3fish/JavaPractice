package com.tristan3fish.revision;

import java.util.StringJoiner;

public class QuestionPrinter {
	
	public void print(Question q){
		System.out.println(q.getQuestion() + ":");
		StringJoiner sj = new StringJoiner(System.lineSeparator() + "\t", "\t", "");
		for(String awnswer: q.getPosibleAnswers()){
			sj.add(awnswer);
		}
		System.out.println(sj.toString());
	}
	
	public String printShortString(Question q){
		StringJoiner sj = new StringJoiner(", ");
		for(String awnswer: q.getPosibleAnswers()){
			sj.add(awnswer);
		}
		return q.getQuestion() + ":" + sj.toString();
	}
	
}
