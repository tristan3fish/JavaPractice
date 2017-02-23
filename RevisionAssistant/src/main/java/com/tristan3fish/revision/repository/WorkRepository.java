package com.tristan3fish.revision.repository;

import java.util.List;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;

public interface WorkRepository {
	public void saveAnswer(Answer a);
	public void saveQuestion(Question q);
	public boolean containsAnswer(Answer a);
	public boolean containsQuestion(Question q);
	public List<Question> getQuestions();
	public List<Answer> getAnswers();
	public void saveScore(Answer a, Question q);
	public Question getWorstQuestion();
	public List<Integer> getSortedScores();
}