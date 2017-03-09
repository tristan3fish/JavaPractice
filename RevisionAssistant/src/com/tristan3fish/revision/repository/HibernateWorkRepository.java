package com.tristan3fish.revision.repository;

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
		return getEntityList("Answer");
	}

	@Override
	public Question getWorstQuestion() {
		List<Question> questions = getEntityList("Question");
		
		int minScore = questions.stream().mapToInt(q -> sc.calculateScore(q)).min().orElse(0);
		
		return questions.stream().filter(q -> Objects.equals(sc.calculateScore(q), minScore)).findFirst().orElse(null);

	}

	@Override
	public int[] getSortedScores() {
		List<Question> questions = getEntityList("Question");

		return questions.stream().mapToInt(q -> sc.calculateScore(q)).sorted().toArray();
	}
	
	private <T> void saveEntity(T entity) {
		Session session = sf.openSession();
        session.beginTransaction();
        session.save(entity);
        //session.close();
        session.getTransaction().commit();
	}
	
	private <T> List<T> getEntityList(String tableName) {
		Session session = sf.openSession();
		Query query = session.createQuery("from " + tableName);
		List<T> result = query.list();
		//session.close();
		return result;
	}
}
