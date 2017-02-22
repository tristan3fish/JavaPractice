package com.tristan3fish.revision;

import java.io.IOException;
import java.util.Scanner;
import com.tristan3fish.revision.repository.InMemoryWorkRepository;
//import com.google.common.base.Stopwatch;

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
			q.print();
			
		      //Stopwatch timer = new Stopwatch().start();

		      long total = 0;
		      for (int i = 0; i < 10000000; i++) {
		         total += i;
		      }

		      //timer.stop();
		      //System.out.println(timer.getElapsedTime());
			
			//start timer
			char c = getCharInput();
			//end timer
			switch (c) {
				case 'q':
					exit = true;
					break;
				case 'r':
					//printDetailedResults();
					break;
				case 'a':
					processAwnswer(0,q);
					break;
				case 's':
					processAwnswer(1,q);
					break;
				case 'd':
					processAwnswer(2,q);
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

	private void processAwnswer(int i, Question q){
		boolean isCorrect = q.isCorrect(i);
		Answer a = new Answer(i, isCorrect, q);
		wb.submitWork(a, q);
		
		if(isCorrect){
			System.out.println("Correct!");
		} else {
			System.out.println("Incorrect! Try this next time: " + q.getCorrectAnswer());
		}
	}

	private char getCharInput() throws IOException {
		Scanner input = new Scanner(System.in);
		
		char c = input.next().charAt(0);
		//char c = (char) System.in.read();
		return c;
	}

}
