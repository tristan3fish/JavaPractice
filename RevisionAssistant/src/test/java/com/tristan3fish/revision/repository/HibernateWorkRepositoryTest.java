package com.tristan3fish.revision.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;
import com.tristan3fish.revision.QuestionFactory;
import com.tristan3fish.revision.repository.HibernateUtil;
import com.tristan3fish.revision.repository.HibernateWorkRepository;

public class HibernateWorkRepositoryTest {

	private static HibernateWorkRepository hwr = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
	private Random rand;
	
    @Before
    public void initialize() {
    	rand = new Random(System.currentTimeMillis());
	}
    
	@Test
	public void canSaveAnswer() {
		Answer a = new Answer(new Date(), 0, false, rand.nextInt());
		hwr.saveOrUpdateAnswer(a);
	}
	
	@Test
	public void canSaveQuestion() {
		Question q = new QuestionFactory().buildQuestion(false);
		hwr.saveOrUpdateQuestion(q);
	}
	
	@Test
	public void canGetAnswers() {
		//shove in an answer just to ensure the second step does not return empty
		hwr.saveOrUpdateAnswer(new Answer(new Date(), 0, false, rand.nextInt()));
		assertFalse(hwr.getAnswers().isEmpty());
	}
	
	@Test
	public void canGetQuestions() {
		//shove in some questions just to ensure the second step does not return empty
		QuestionFactory qf = new QuestionFactory();
		hwr.saveOrUpdateQuestion(qf.buildQuestion(false));
		hwr.saveOrUpdateQuestion(qf.buildQuestion(true));
		
		List<Question> questions = hwr.getQuestions();
		assertFalse(questions.isEmpty());
	}
	
	@Test
	public void canSaveAndRetreiveAnswer() {
		Answer a = new Answer(new Date(), 0, false, rand.nextInt());
		hwr.saveOrUpdateAnswer(a);

		assertTrue(hwr.containsAnswer(a));
	}
	
	@Test
	public void canSaveAndRetreiveQuestion() {
		QuestionFactory qf = new QuestionFactory();
		Question q1 = qf.buildQuestion(false);
		Question q2 = qf.buildQuestion(true);
		
		hwr.saveOrUpdateQuestion(q1);
		hwr.saveOrUpdateQuestion(q2);
		
		List<Question> questions = hwr.getQuestions();
		assertFalse(questions.isEmpty());

		assertTrue(hwr.containsQuestion(q1));
		assertTrue(hwr.containsQuestion(q2));
	}
	
	@Test
	public void canSaveQuestionAndRetreiveAttemptedAnswers() {
		Question q = new QuestionFactory().buildQuestion(false);
		Answer a = new Answer(new Date(), 0, false, rand.nextInt());
		q.addAttempt(a);
		
		hwr.saveOrUpdateQuestion(q);
	}
	
	@Test
	public void canPurgeAllData() {
		Question q = new QuestionFactory().buildQuestion(false);
		Answer a = new Answer(new Date(), 0, false, rand.nextInt());
		q.addAttempt(a);
		hwr.saveOrUpdateQuestion(q);
		
		hwr.purge();
		
		List<Question> questions = hwr.getQuestions();
		assertTrue(questions.isEmpty());
		List<Answer> answers = hwr.getAnswers();
		assertTrue(answers.isEmpty());
	}
	
	@Test
	public void canGetSortedScores() {
		hwr.purge();
		
		Question q = new QuestionFactory().buildQuestion(false);
		Answer a = new Answer(new Date(), 0, false, rand.nextInt());
		q.addAttempt(a);
		hwr.saveOrUpdateQuestion(q);
		
		List<Integer> scores = hwr.getSortedScores();
		assertTrue(scores.size() == 1);
		assertTrue(scores.get(0) == -1);
		
	}
}