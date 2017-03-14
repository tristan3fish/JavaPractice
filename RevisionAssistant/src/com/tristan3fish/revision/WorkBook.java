package com.tristan3fish.revision;

import java.util.StringJoiner;

import com.tristan3fish.revision.repository.WorkRepository;

public class WorkBook {

	private WorkRepository workRepository;
	private QuestionFactory qf;
	
	public WorkBook(WorkRepository wr){
		qf = new QuestionFactory();
		workRepository = wr;
	}
	
	public void submitWork(Answer a, Question q){
		
		q.addAttempt(a);
		
		//if(!workRepository.containsQuestion(q)){
		workRepository.saveOrUpdateQuestion(q);
		//}
//		if(!workRepository.containsAnswer(a)){
//			workRepository.saveAnswer(a);
//		}
	}
	
	private int ctr = 0;
	
	public Question getNextQuestion() {
		ctr++;
		ctr%=8;
		Question result = null;
		if(ctr == 1 || ctr == 3){
			result = qf.buildQuestion(false);
		}else if(ctr == 2 || ctr == 4){
			result = qf.buildQuestion(true);
		}else{
			result = workRepository.getWorstQuestion();
		}
		return result;
	}

	public String getSortedScores() {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for(Integer scores: workRepository.getSortedScores()){
			sj.add(scores.toString());
		}
		return sj.toString();
	}
}
