package com.tristan3fish.revision.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;

public class HibernateWorkRepository implements WorkRepository {

	private SessionFactory sf;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getSortedScores() {

		
		return null;
	}
	
	private <T> void saveEntity(T entity) {
		Session session = sf.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
	}
}
