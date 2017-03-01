package com.tristan3fish.revision;

public class ScoreCalculator {
	
	public int calculateScore(Question q){
		int score = 0;
		for(Answer a: q.getAttemptedAnswers()){
			score += (a.isCorrect() ? 1 : -1);
		}
		return score;
	}
	
}
