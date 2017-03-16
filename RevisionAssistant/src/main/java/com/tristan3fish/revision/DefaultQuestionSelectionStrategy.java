package com.tristan3fish.revision;

import com.tristan3fish.revision.repository.WorkRepository;

public class DefaultQuestionSelectionStrategy implements QuestionSelectionStrategy {
	
	private int ctr;
	private WorkRepository workRepository;
	private QuestionFactory qf;
	
	public DefaultQuestionSelectionStrategy(WorkRepository workRepository){
		ctr = 0;
		this.workRepository = workRepository;
		qf = new QuestionFactory();
	}
	
	@Override
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
}
