package com.tristan3fish.revision;

import com.tristan3fish.revision.repository.WorkRepository;

public class RepoOnlyQuestionSelectionStrategy implements QuestionSelectionStrategy {
	
	private WorkRepository workRepository;
	
	public RepoOnlyQuestionSelectionStrategy(WorkRepository workRepository){
		this.workRepository = workRepository;
	}
	
	@Override
	public Question getNextQuestion() {
		return workRepository.getWorstQuestion();
	}

}
