package com.tristan3fish.revision.repository;

import java.util.List;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;

public class HibernateWorkRepository implements WorkRepository {

	@Override
	public void saveAnswer(Answer a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveQuestion(Question q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsAnswer(Answer a) {
		return false;
	}

	@Override
	public boolean containsQuestion(Question q) {
		return false;
	}
	
	@Override
	public List<Question> getQuestions() {
		return null;
	}

	@Override
	public List<Answer> getAnswers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveScore(Answer a, Question q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Question getWorstQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getSortedScores() {
		// TODO Auto-generated method stub
		return null;
	}
}
