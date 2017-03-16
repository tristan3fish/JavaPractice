package com.tristan3fish.revision.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;
import com.tristan3fish.revision.ScoreCalculator;

public class InMemoryWorkRepository implements WorkRepository {

	private HashMap<Integer, Answer> answers = new HashMap<>();
	private HashMap<Integer, Question> questions = new HashMap<>();
	
	//would like to move this out as the repository 
	//should not need to know about this class
	private ScoreCalculator sc = new ScoreCalculator();
	
	@Override
	public void saveOrUpdateAnswer(Answer a) {
		System.out.println("hesitation: " + a.getHesitation_s());
		answers.put((Integer)a.hashCode(), a);
	}

	@Override
	public void saveOrUpdateQuestion(Question q) {
		questions.put((Integer)q.hashCode(), q);
	}

	@Override
	public boolean containsAnswer(Answer a) {
		return answers.containsKey((Integer)a.hashCode());
	}

	@Override
	public boolean containsQuestion(Question q) {
		return questions.containsKey((Integer)q.hashCode());
	}

	@Override
	public List<Question> getQuestions() {
		return new ArrayList<Question>(questions.values());
	}

	@Override
	public List<Answer> getAnswers() {
		return new ArrayList<Answer>(answers.values());
	}

	@Override
	public Question getWorstQuestion() {
		int minScore = questions.values().stream().mapToInt(q -> sc.calculateScore(q)).min().orElse(0);
		
		return questions.values().stream().filter(q -> Objects.equals(sc.calculateScore(q), minScore)).findFirst().orElse(null);
	}

	@Override
	public List<Integer> getSortedScores() {
		return (List<Integer>) questions.values().stream().mapToInt(q -> sc.calculateScore(q)).sorted();
	}

	@Override
	public void purge() {
		answers = new HashMap<>();
		questions = new HashMap<>();
	}
}
