package com.tristan3fish.revision.protobuf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

import com.tristan3fish.revision.Answer;

public class ProtoServiceTest {
	
	@Test
	public void canInitialise() {
		String fileName = System.getProperty("user.home") + "/answerProto";
		ProtoService ps = new ProtoService(new FileProtoSender(fileName), new PollingFileProtoReceiver(fileName));
		
		assertNotNull(ps);
	}
	
	@Test
	public void canSendAndReceiveAnswerWithDefaults() {
		String fileName = System.getProperty("user.home") + "/answerProto";
		ProtoService ps = new ProtoService(new FileProtoSender(fileName), new PollingFileProtoReceiver(fileName));
		
		int answerId = 0;
		Date timeCreated = new Date();
		int numericAnswer = 0;
		boolean isCorrect = false;
		long hesitation = 0;
		
		Answer a = new Answer();
		a.setAnswerId(answerId);
		a.setTimeCreated(timeCreated);
		a.setAnswer(numericAnswer);
		a.setCorrect(isCorrect);
		a.setHesitation_ms(hesitation);
		//a.setQuestion(ap.getQuestionId());
		
		ps.sendAnswer(a);
		Answer result = ps.startListeningForAnswer();
		
		assertNotNull(result);
		assertNotNull(result.getAnswerId());
		assertEquals(answerId, result.getAnswerId());
		assertNotNull(result.getTimeCreated());
		assertEquals(timeCreated.toString(), result.getTimeCreated().toString());
		assertNotNull(result.getAnswer());
		assertEquals(numericAnswer, result.getAnswer());
		assertNotNull(result.isCorrect());
		assertEquals(isCorrect, result.isCorrect());
		assertNotNull(result.getHesitation_ms());
		assertEquals(hesitation, result.getHesitation_ms());

	}
	
	@Test
	public void canSendAndReceiveAnswerWithRandomData() {
		String fileName = System.getProperty("user.home") + "/answerProto";
		ProtoService ps = new ProtoService(new FileProtoSender(fileName), new PollingFileProtoReceiver(fileName));
		
		Random r = new Random(System.currentTimeMillis());
		
		int answerId = r.nextInt(10000);
		Date timeCreated = new Date();
		timeCreated.setTime(r.nextInt(100000000));
		int numericAnswer = r.nextInt(2);
		boolean isCorrect = r.nextInt(1) == 1 ? true : false;
		long hesitation = r.nextInt(1000000);
		
		Answer a = new Answer();
		a.setAnswerId(answerId);
		a.setTimeCreated(timeCreated);
		a.setAnswer(numericAnswer);
		a.setCorrect(isCorrect);
		a.setHesitation_ms(hesitation);
		//a.setQuestion(ap.getQuestionId());
		
		ps.sendAnswer(a);
		Answer result = ps.startListeningForAnswer();
		
		assertNotNull(result);
		assertNotNull(result.getAnswerId());
		assertEquals(answerId, result.getAnswerId());
		assertNotNull(result.getTimeCreated());
		assertEquals(timeCreated.toString(), result.getTimeCreated().toString());
		assertNotNull(result.getAnswer());
		assertEquals(numericAnswer, result.getAnswer());
		assertNotNull(result.isCorrect());
		assertEquals(isCorrect, result.isCorrect());
		assertNotNull(result.getHesitation_ms());
		assertEquals(hesitation, result.getHesitation_ms());

	}
}
