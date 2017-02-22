package com.tristan3fish.revision.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;

public class InMemoryWorkRepository implements WorkRepository {

	private HashMap<Integer, Answer> answers = new HashMap<>();
	private HashMap<Integer, Question> questions = new HashMap<>();
	private HashMap<Question, Integer> score = new HashMap<>();
	
	@Override
	public void saveAnswer(Answer a) {
		//System.out.println("saving answer: " + a.hashCode());
		answers.put((Integer)a.hashCode(), a);
	}

	@Override
	public void saveQuestion(Question q) {
		//System.out.println("saving question: " + q.hashCode());
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
	public void saveScore(Answer a, Question q) {
		int incrementer = a.isCorrect() ? 1 : -1;
		if(score.containsKey(q)){
			score.put(q, score.get(q) + incrementer);
		} else {
			score.put(q, incrementer);
		}
	}

	@Override
	public Question getWorstQuestion() {
		int minScore = Collections.min(score.values());
		Question worstQuestion =
			score
			.entrySet()
            .stream()
            .filter(entry -> Objects.equals(entry.getValue(), minScore))
            .findFirst().get().getKey();
		
		return worstQuestion;
	}

	@Override
	public List<Integer> getSortedScores() {
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(score.values());

		Collections.sort(result);
		return result;
	}
}
