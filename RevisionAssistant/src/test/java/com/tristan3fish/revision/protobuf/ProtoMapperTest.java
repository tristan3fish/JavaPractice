package com.tristan3fish.revision.protobuf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import org.junit.Test;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto;
import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.Builder;

public class ProtoMapperTest {
	
	@Test
	public void canInitialise() {
		ProtoMapper pm = new ProtoMapper();
		assertNotNull(pm);
	}
	
//	@Test
//	public void canFormatDateToString() {
//		ProtoMapper pm = new ProtoMapper();
//		//Random r = new Random(System.currentTimeMillis());
//		Date timeCreated = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
//		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//		try {
//			timeCreated = sdf.parse("Thu Jan 01 18:45:26 UTC 1970");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		//timeCreated.setTime(r.nextInt(100000000));
//		
//		String result = pm.formatDateToString(timeCreated);
//		assertEquals(timeCreated.toString(), result);
//	}
	
	@Test
	public void isParseAndFormatInvertable() {
		ProtoMapper pm = new ProtoMapper();

		String timeCreatedStr = "Thu Jan 01 19:12:56 1970";
		
		Date resultDate = pm.parseStringToDate(timeCreatedStr);
		String result = pm.formatDateToString(resultDate);
		
		assertEquals(timeCreatedStr, result);
	}
	
	@Test
	public void canConvertAnswerToProto() {
		ProtoMapper pm = new ProtoMapper();
		
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
		
		AnswerProto result = pm.convertAnswerToProto(a);
		
		assertNotNull(result);
		assertNotNull(result.getAnswerId());
		assertEquals(answerId, result.getAnswerId());
		assertNotNull(result.getTimeCreated());	
		assertEquals(pm.formatDateToString(timeCreated), result.getTimeCreated().toString());
		assertNotNull(result.getAnswerNumeric());
		assertEquals(numericAnswer, result.getAnswerNumeric());
		assertNotNull(result.getCorrect());
		assertEquals(isCorrect, result.getCorrect());
		assertNotNull(result.getHesitationMs());
		assertEquals(hesitation, result.getHesitationMs());
	}
	
	@Test
	public void canConvertProtoToAnswer() {
		ProtoMapper pm = new ProtoMapper();
		
		Random r = new Random(System.currentTimeMillis());
		
		int answerId = r.nextInt(10000);
		Date timeCreated = new Date();
		timeCreated.setTime(r.nextInt(100000000));
		int numericAnswer = r.nextInt(2);
		boolean isCorrect = r.nextInt(1) == 1 ? true : false;
		long hesitation = r.nextInt(1000000);

		Builder answerProtoBuilder = AnswerProtos.AnswerProto.newBuilder();
		
		AnswerProto answerProto = answerProtoBuilder
				.setAnswerId(answerId)
				.setTimeCreated(pm.formatDateToString(timeCreated))
				.setAnswerNumeric(numericAnswer)
				.setCorrect(isCorrect)
				.setHesitationMs(hesitation)
				//.setQuestionId(a.getQuestion().getQuestionId())
				.build();
		
		Answer result = pm.convertProtoToAnswer(answerProto);
		
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
