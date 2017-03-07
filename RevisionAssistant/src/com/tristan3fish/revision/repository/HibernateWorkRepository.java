package com.tristan3fish.revision.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;
import com.tristan3fish.revision.ScoreCalculator;

public class HibernateWorkRepository implements WorkRepository {

	private SessionFactory sf;
	
	//would like to move this out as the repository 
	//should not need to know about this class
	private ScoreCalculator sc = new ScoreCalculator();
	
	public HibernateWorkRepository() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void saveAnswer(Answer a) {
        saveEntity(a);
	}

	@Override
	public void saveQuestion(Question q) {
        saveEntity(q);
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

	//@Override
	//public void saveScore(Answer a, Question q) {
	//	int incrementer = a.isCorrect() ? 1 : -1;
		//if(score.containsKey(q)){
		//	score.put(q, score.get(q) + incrementer);
		//} else {
		//	score.put(q, incrementer);
		//}
	//}

	@Override
	public Question getWorstQuestion() {
		Session session = sf.openSession();
		Query query = session.createQuery("from Question");
		List<Question> questions = query.list();
		
		
		int minScore = questions.stream().mapToInt(q -> sc.calculateScore(q)).min().orElse(0);
		
		return questions.stream().filter(q -> Objects.equals(sc.calculateScore(q), minScore)).findFirst().orElse(null);

	}

	@Override
	public int[] getSortedScores() {
		Session session = sf.openSession();
		Query query = session.createQuery("from Question");
		List<Question> questions = query.list();
		
		//return null;
		return questions.stream().mapToInt(q -> sc.calculateScore(q)).sorted().toArray();
	}
	
	private <T> void saveEntity(T entity) {
		Session session = sf.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
	}
}
