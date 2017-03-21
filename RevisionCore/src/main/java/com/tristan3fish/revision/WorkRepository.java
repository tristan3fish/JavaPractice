package com.tristan3fish.revision;

import java.util.List;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;

public interface WorkRepository {
	public void saveOrUpdateAnswer(Answer a);
	public void saveOrUpdateQuestion(Question q);
	public boolean containsAnswer(Answer a);
	public boolean containsQuestion(Question q);
	public List<Question> getQuestions();
	public List<Answer> getAnswers();
	public Question getWorstQuestion();
	public List<Integer> getSortedScores();
	public void purge();
}
