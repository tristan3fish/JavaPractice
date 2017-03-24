package com.tristan3fish.revision.protobuf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto;
import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto.Builder;

public class PollingFileProtoReceiver implements ProtoReceiver {

	private String fileName;
	
	public PollingFileProtoReceiver(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public AnswerProto receiveAnswerProto() {
		while(true){
	    	File f = new File(fileName);
	    	if(f.exists() && !f.isDirectory()) { 

	    		InputStream fileStream = new InputStream() { @Override public int read() throws IOException {return 0;}};
	    		
				try {
					fileStream = new FileInputStream(fileName);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
	    		
				return extractProtoFromStream(fileStream);
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


	private AnswerProto extractProtoFromStream(InputStream fileStream) {
		//AnswerProto answerProtoFromFile = AnswerProto.parseFrom(fileStream);
		Builder answerProtoBuilder = AnswerProtos.AnswerProto.newBuilder();
		try {
			answerProtoBuilder.mergeFrom(fileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return answerProtoBuilder.build();
	}

}
