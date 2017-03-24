package com.tristan3fish.revision.protobuf;

import com.tristan3fish.revision.Answer;
import com.tristan3fish.revision.Question;
import com.tristan3fish.revision.protobuf.AnswerProtos.AnswerProto;

public class ProtoService {

	private ProtoMapper protoMapper;
	private ProtoSender protoSender;
	private ProtoReceiver protoReceiver;
	
	public ProtoService(ProtoSender protoSender, ProtoReceiver protoReceiver){
		this.protoMapper = new ProtoMapper();
		this.protoSender = protoSender;
		this.protoReceiver = protoReceiver;
	}
	
	public void sendAnswer(Answer a){
		AnswerProto answerProto = protoMapper.convertAnswerToProto(a);
		protoSender.send(answerProto);
	}
	
	public void sendQuestion(Question q){
		
	}
	
	public Answer startListeningForAnswer(){
		AnswerProto answerProto = protoReceiver.receiveAnswerProto();
		return protoMapper.convertProtoToAnswer(answerProto);
	}

	public static void main(String[] args) {
		String fileName = System.getProperty("user.home") + "/answerProto";
		ProtoService ps = new ProtoService(new FileProtoSender(fileName), new PollingFileProtoReceiver(fileName));
		Answer a = ps.startListeningForAnswer();
		System.out.println(a);
	}
}
