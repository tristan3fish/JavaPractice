package com.tristan3fish.revision;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.tristan3fish.revision.repository.InMemoryWorkRepository;
import com.google.common.base.Stopwatch;

public class JavaConsoleApp {

	private WorkBook wb;
	
	public static void main(String[] args) {
		try {
			new JavaConsoleApp().startLoop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JavaConsoleApp(){
		wb = new WorkBook(new InMemoryWorkRepository());
	}
	
	private void startLoop() throws IOException {
		boolean exit = false;
		
		while(!exit){
			
			Question q = wb.getNextQuestion();
			
			Answer a = null;
			
			q.print();
			
		    Stopwatch timer = Stopwatch.createStarted();
			char c = getCharInput();
			timer.stop();
			long hesitation_ms = timer.elapsed(TimeUnit.MILLISECONDS);
			
			
			switch (c) {
				case 'q':
					exit = true;
					break;
				case 'r':
					//printDetailedResults();
					break;
				case 'a':
					a = new Answer(0, q, hesitation_ms);
					processAwnswer(a, q);
					break;
				case 's':
					a = new Answer(1, q, hesitation_ms);
					processAwnswer(a, q);
					break;
				case 'd':
					a = new Answer(2, q, hesitation_ms);
					processAwnswer(a, q);
					break;
				default:
					break;
			}
			
			printSortedScores();
			System.out.println();
		}
	}
	
	private void printSortedScores() {
		System.out.println(wb.getSortedScores());
	}

	private void processAwnswer(Answer a, Question q){
		
		wb.submitWork(a, q);
		
		if(a.isCorrect()){
			System.out.println("Correct!");
		} else {
			System.out.println("Incorrect! Try this next time: " + q.getCorrectAnswer());
		}
	}

	private char getCharInput() throws IOException {
		Scanner input = new Scanner(System.in);
		
		char c = input.next().charAt(0);
		//char c = (char) System.in.read();
		input.close();
		return c;
	}

}
