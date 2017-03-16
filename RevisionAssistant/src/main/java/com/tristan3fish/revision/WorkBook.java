package com.tristan3fish.revision;

import java.util.StringJoiner;

import com.tristan3fish.revision.repository.WorkRepository;

public class WorkBook {

	private WorkRepository workRepository;
	private QuestionSelectionStrategy questionSelectionStrategy;
	
	public WorkBook(WorkRepository workRepository, QuestionSelectionStrategy questionSelectionStrategy){
		this.workRepository = workRepository;
		this.setQuestionSelectionStrategy(questionSelectionStrategy);
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
	
	public void reset(){
		workRepository.purge();
	}
	
	public Question getNextQuestion() {
		return getQuestionSelectionStrategy().getNextQuestion();
	}

	public String getSortedScores() {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for(Integer scores: workRepository.getSortedScores()){
			sj.add(scores.toString());
		}
		return sj.toString();
	}

	public QuestionSelectionStrategy getQuestionSelectionStrategy() {
		return questionSelectionStrategy;
	}

	public void setQuestionSelectionStrategy(QuestionSelectionStrategy questionSelectionStrategy) {
		this.questionSelectionStrategy = questionSelectionStrategy;
	}
}
