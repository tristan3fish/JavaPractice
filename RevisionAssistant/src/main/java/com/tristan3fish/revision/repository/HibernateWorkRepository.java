package com.tristan3fish.revision.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;
import com.tristan3fish.revision.ScoreCalculator;
import com.tristan3fish.revision.WorkRepository;

public class HibernateWorkRepository implements WorkRepository {

	private SessionFactory sf;
	
	public HibernateWorkRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void saveOrUpdateAnswer(Answer a) {
		saveOrUpdateEntity(a);
	}

	@Override
	public void saveOrUpdateQuestion(Question q) {
		saveOrUpdateEntity(q);
	}
	
	@Override
	public List<Question> getQuestions() {
		return getEntityList("Question");
	}

	@Override
	public List<Answer> getAnswers() {
		return getEntityList("Answer");
	}

	@Override
	public Question getWorstQuestion() {
		List<Question> questions = getEntityList("Question");
		Session session = sf.openSession();
		session.beginTransaction();
		
		Question result = null;
		int minScore = Integer.MAX_VALUE;
		for(Question q : questions){
			Iterator<Answer> itr = session
				.createQuery("select a from Answer a where a.question = :Question")
				.setEntity("Question", q)
	            .list()
	            .iterator();
			
			int score = 0;
			while ( itr.hasNext() ) {
				Answer a = itr.next();
				score += a.isCorrect()? 1:-1;
			}
			if(score < minScore){
				minScore = score;
				result = q;
			}
		}
		
	    session.getTransaction().commit();
	    session.close();
	    
	    return result;
	}

	@Override
	public List<Integer> getSortedScores() {	
		List<Question> questions = getEntityList("Question");
		Session session = sf.openSession();
		session.beginTransaction();
		List<Integer> scores = new ArrayList<Integer>();
		for(Question q : questions){
			Iterator<Answer> itr = session
				.createQuery("select a from Answer a where a.question = :Question")
				.setEntity("Question", q)
	            .list()
	            .iterator();
			
			int score = 0;
			while ( itr.hasNext() ) {
				Answer a = itr.next();
				score += a.isCorrect()? 1:-1;
			}
			
			scores.add(score);
		}
	    session.getTransaction().commit();
	    session.close();
	    
	    Collections.sort(scores);
	    return scores;
	}
	
	@Override
	public boolean containsAnswer(Answer a) {
		Session session = sf.openSession();
		session.beginTransaction();
		
	    Query query = session.createQuery("select 1 from Answer a where a.answerId = :ANSWERID");
	    query.setInteger("ANSWERID", a.getAnswerId() );
	    boolean result = query.uniqueResult() != null;
	    
	    session.getTransaction().commit();
	    session.close();
	    return result;
	}

	@Override
	public boolean containsQuestion(Question q) {
		Session session = sf.openSession();
		session.beginTransaction();
		
	    Query query = session.createQuery("select 1 from Question q where q.questionId = :QUESTIONID");
	    query.setInteger("QUESTIONID", q.getQuestionId() );
	    boolean result = query.uniqueResult() != null;
	    
	    session.getTransaction().commit();
	    session.close();
	    return result;
	}
	
	@Override
	public void purge() {
		Session session = sf.openSession();
        session.beginTransaction();
        
        session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
        session.createSQLQuery("TRUNCATE TABLE Question").executeUpdate();
        session.createSQLQuery("TRUNCATE TABLE Answer").executeUpdate();
        session.createSQLQuery("TRUNCATE TABLE PosibleAnswer").executeUpdate();
        session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();

        session.getTransaction().commit();
        session.close();
	}
	
	private <T> void saveOrUpdateEntity(T entity) {
		Session session = sf.openSession();
        session.beginTransaction();
        
        session.saveOrUpdate(entity);
        
        session.getTransaction().commit();
        session.close();
	}
	
	private <T> List<T> getEntityList(String tableName) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from " + tableName);
		List<T> result = query.list();

        session.getTransaction().commit();
        session.close();
		return result;
	}
}
