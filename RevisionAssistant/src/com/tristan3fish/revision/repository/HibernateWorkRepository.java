package com.tristan3fish.revision.repository;

import java.util.HashMap;
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
		int minScore = questions.stream().mapToInt(q -> sc.calculateScore(q)).min().orElse(0);
		return questions.stream().filter(q -> Objects.equals(sc.calculateScore(q), minScore)).findFirst().orElse(null);
	}

	@Override
	public int[] getSortedScores() {
		List<Question> questions = getEntityList("Question");
		return questions.stream().mapToInt(q -> sc.calculateScore(q)).sorted().toArray();
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
