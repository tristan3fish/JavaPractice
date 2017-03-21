package com.tristan3fish.revision;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.tristan3fish.revision.repository.HibernateUtil;
import com.tristan3fish.revision.repository.HibernateWorkRepository;


public class WorkBookTest {
	
	@Test
	public void canInitialise() {
		WorkRepository workRepository = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
		WorkBook wb = new WorkBook(workRepository, new DefaultQuestionSelectionStrategy(workRepository));
		
		//WorkRepository workRepository = new InMemoryWorkRepository()
		//WorkBook wb = new WorkBook(workRepository);
		assertNotNull(wb);
	}
	
	@Test
	public void canGetNextQuestion() {
		WorkRepository workRepository = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
		WorkBook wb = new WorkBook(workRepository, new DefaultQuestionSelectionStrategy(workRepository));
		
		Question q = wb.getNextQuestion();
		assertNotNull(q);
	}

	@Test
	public void canSubmitWork() {
		WorkRepository workRepository = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
		WorkBook wb = new WorkBook(workRepository, new DefaultQuestionSelectionStrategy(workRepository));
		
		Question q = wb.getNextQuestion();
		Answer a = new Answer(new Date(), 0, q.isCorrect(0), 100);
		wb.submitWork(a, q);
	}
	
	@Test
	public void canGetSortedScores() {
		WorkRepository workRepository = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
		WorkBook wb = new WorkBook(workRepository, new DefaultQuestionSelectionStrategy(workRepository));
		
		Question q = wb.getNextQuestion();
		Answer a = new Answer(new Date(), 0, q.isCorrect(0), 100);
		wb.submitWork(a, q);
		
		q = wb.getNextQuestion();
		a = new Answer(new Date(), 0, q.isCorrect(0), 100);
		wb.submitWork(a, q);
		
		assertNotNull(wb.getSortedScores());
	}
	
	@Test
	public void canResetWorkbook(){
		WorkRepository workRepository = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
		WorkBook wb = new WorkBook(workRepository, new RepoOnlyQuestionSelectionStrategy(workRepository));
		QuestionFactory qf = new QuestionFactory();
		
		//reset the workbook
		
		//one correct answer
		Question q = qf.buildQuestion(false);
		int idx = q.getIndexOfCorrectAnswer();
		Answer a = new Answer(new Date(), idx, q.isCorrect(idx), 100);
		wb.submitWork(a, q);
		
		wb.reset();
		
		assertTrue(wb.getSortedScores().equals("[]"));		
	}
	
	@Test
	public void canCorrectlyCalculateScores() {
		WorkRepository workRepository = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
		WorkBook wb = new WorkBook(workRepository, new RepoOnlyQuestionSelectionStrategy(workRepository));
		QuestionFactory qf = new QuestionFactory(1000); //we put a seed in for the random that wont change each time we run the test. 
		
		//reset the workbook
		wb.reset();
		assertTrue(wb.getSortedScores().equals("[]"));
		
		//one correct answer
		Question q = qf.buildQuestion(false);
		int idx = q.getIndexOfCorrectAnswer();
		Answer a = new Answer(new Date(), idx, q.isCorrect(idx), 100);
		wb.submitWork(a, q);
		assertTrue(wb.getSortedScores().equals("[1]"));
		
		//get the previous question and correctly answer it again
		Answer a2 = new Answer(new Date(), idx, q.isCorrect(idx), 100);
		wb.submitWork(a2, q);
		assertTrue(wb.getSortedScores().equals("[2]"));
		
		//get the previous question and incorrectly answer it
		Answer a3 = new Answer(new Date(), (idx+1)%3, q.isCorrect((idx+1)%3), 100);
		wb.submitWork(a3, q);
		assertTrue(wb.getSortedScores().equals("[1]"));		
		
		//new question incorrect answer
		Question q2 = qf.buildQuestion(true);
		int idx2 = q2.getIndexOfCorrectAnswer();
		Answer a4 = new Answer(new Date(), (idx2+1)%3, q2.isCorrect((idx2+1)%3), 100);
		wb.submitWork(a4, q2);
		assertTrue(wb.getSortedScores().equals("[-1, 1]"));
		
		//previous question incorrect answer
		Answer a5 = new Answer(new Date(), (idx2+1)%3, q2.isCorrect((idx2+1)%3), 100);
		wb.submitWork(a5, q2);
		assertTrue(wb.getSortedScores().equals("[-2, 1]"));
		
	}
	
	@Test
	public void canCorrectlyCalculateScoreFromRepoViaWorkbook() {
		WorkRepository workRepository = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
		WorkBook wb = new WorkBook(workRepository, new RepoOnlyQuestionSelectionStrategy(workRepository));
		QuestionFactory qf = new QuestionFactory();
		
		//reset the workbook
		wb.reset();
		assertTrue(wb.getSortedScores().equals("[]"));
		
		//new question incorrect answer
		Question q2 = qf.buildQuestion(true);
		int idx2 = q2.getIndexOfCorrectAnswer();
		Answer a4 = new Answer(new Date(), (idx2+1)%3, q2.isCorrect((idx2+1)%3), 100);
		wb.submitWork(a4, q2);
		assertTrue(wb.getSortedScores().equals("[-1]"));
		
		//next i will be taking q2 from the workbook who uses the repo. will correctly anser twice
		Question q3 = wb.getNextQuestion();
		int idx3 = q3.getIndexOfCorrectAnswer();
		Answer a6 = new Answer(new Date(), idx3, q3.isCorrect(idx3), 100);
		wb.submitWork(a6, q3);
		assertTrue(wb.getSortedScores().equals("[0]"));
		
		//question from workbook
		Question q4 = wb.getNextQuestion();
		int idx4 = q4.getIndexOfCorrectAnswer();
		Answer a7 = new Answer(new Date(), idx4, q4.isCorrect(idx4), 100);
		wb.submitWork(a7, q4);
		assertTrue(wb.getSortedScores().equals("[1]"));
		
		//new question incorrect answer
		Question q5 = qf.buildQuestion(false);
		int idx5 = q5.getIndexOfCorrectAnswer();
		Answer a8 = new Answer(new Date(), (idx5+1)%3, q5.isCorrect((idx5+1)%3), 100);
		wb.submitWork(a8, q5);
		assertTrue(wb.getSortedScores().equals("[-1, 1]"));
	}
}
