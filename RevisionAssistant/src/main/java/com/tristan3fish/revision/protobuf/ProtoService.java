package com.tristan3fish.revision.protobuf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;
import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto;
import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.Builder;

public class ProtoService {
	
	private static String home = System.getProperty("user.home");
	
	public static void main(String[] args) {
	    while(true){
	    	File f = new File(home + "/answerProto");
	    	if(f.exists() && !f.isDirectory()) { 
				// read
	    		System.out.println("File found: ");
	    		InputStream fileStream = new InputStream() { @Override public int read() throws IOException {return 0;}};
	    		
				try {
					fileStream = new FileInputStream(home + "/answerProto");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
	    		
				extractProtoFromStream(fileStream);
	    	} else {
	    		System.out.println("Waiting for file ...");
	    	}
	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	
	}
	
	public void sendAnswer(Answer a){
		AnswerProto answerProto = convertAnswerToProto(a);
		sendAnswerProto(answerProto);
	}

	private void sendAnswerProto(AnswerProto answerProto) {
		File f = new File(home + "/answerProto");
    	if(!f.exists()){
    		try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
		// write
		try {
			FileOutputStream output = new FileOutputStream(home + "/answerProto");
	        answerProto.writeTo(output);
	        output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static AnswerProto extractProtoFromStream(InputStream fileStream) {
			//AnswerProto answerProtoFromFile = AnswerProto.parseFrom(fileStream);
			Builder answerProtoBuilder = AnswerProtos.AnswerProto.newBuilder();
			try {
				answerProtoBuilder.mergeFrom(fileStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return answerProtoBuilder.build();
	}
	private AnswerProto convertAnswerToProto(Answer a) {
		//create the builder
		Builder answerProtoBuilder = AnswerProtos.AnswerProto.newBuilder();
		
		//map the data into the builder then build
		AnswerProto answerProto = answerProtoBuilder
				.setAnswerId(a.getAnswerId())
				.setTimeCreated(a.getTimeCreated().toString())
				.setAnswerNumeric(a.getAnswer())
				.setCorrect(a.isCorrect())
				.setHesitationMs(a.getHesitation_ms())
				//.setQuestionId(a.getQuestion().getQuestionId())
				.build();
		
		return answerProto;
	}

	public void sendQuestion(Question q){
		
	}
	
}
