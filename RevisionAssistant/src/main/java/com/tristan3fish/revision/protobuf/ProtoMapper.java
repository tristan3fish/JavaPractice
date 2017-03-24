package com.tristan3fish.revision.protobuf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto;
import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.Builder;

public class ProtoMapper {
	
	private static String dateFormat = "EEE MMM dd HH:mm:ss yyyy";
	
	public AnswerProto convertAnswerToProto(Answer a) {
		//create the builder
		Builder answerProtoBuilder = AnswerProtos.AnswerProto.newBuilder();
		
		//map the data into the builder then build
		AnswerProto answerProto = answerProtoBuilder
			.setAnswerId(a.getAnswerId())
			.setTimeCreated(formatDateToString(a.getTimeCreated()))
			.setAnswerNumeric(a.getAnswer())
			.setCorrect(a.isCorrect())
			.setHesitationMs(a.getHesitation_ms())
			//.setQuestionId(a.getQuestion().getQuestionId())
			.build();
		
		return answerProto;
	}

	public String formatDateToString(Date d) {
		SimpleDateFormat dateFormater = new SimpleDateFormat(dateFormat);
		dateFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
		return dateFormater.format(d);
	}
	
	public Date parseStringToDate(String d) {
		SimpleDateFormat dateFormater = new SimpleDateFormat(dateFormat);
		dateFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			return dateFormater.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Answer convertProtoToAnswer(AnswerProto ap) {
		Answer a = new Answer();
		
		a.setAnswerId(ap.getAnswerId());
		a.setTimeCreated(parseStringToDate(ap.getTimeCreated()));
		a.setAnswer(ap.getAnswerNumeric());
		a.setCorrect(ap.getCorrect());
		a.setHesitation_ms(ap.getHesitationMs());
		//a.setQuestion(ap.getQuestionId());
		
		return a;
	}
}
