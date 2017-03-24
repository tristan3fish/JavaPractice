package com.tristan3fish.revision;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.tristan3fish.revision.repository.HibernateUtil;
import com.tristan3fish.revision.repository.HibernateWorkRepository;
import com.tristan3fish.revision.WorkRepository;
import com.tristan3fish.revision.protobuf.FileProtoSender;
import com.tristan3fish.revision.protobuf.PollingFileProtoReceiver;
import com.tristan3fish.revision.protobuf.ProtoService;

public class JavaConsoleApp {

	private WorkBook wb;
	private QuestionPrinter qp;
	
	public static void main(String[] args) {
		try {
			new JavaConsoleApp().startLoop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JavaConsoleApp(){
		
		WorkRepository workRepository = new HibernateWorkRepository(HibernateUtil.getSessionFactory());
		//WorkRepository workRepository = new InMemoryWorkRepository()
		wb = new WorkBook(workRepository, new DefaultQuestionSelectionStrategy(workRepository));
		//wb = new WorkBook(workRepository);
		
		qp = new QuestionPrinter();
	}
	
	private void startLoop() throws IOException {
		
		boolean exit = false;
		
		while(!exit){
			Question q = wb.getNextQuestion();
			
			Answer a = null;
			
			qp.print(q);
			
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
					a = new Answer(new Date(), 0, q.isCorrect(0), hesitation_ms);
					processAnswer(a, q);
					break;
				case 's':
					a = new Answer(new Date(), 1, q.isCorrect(1), hesitation_ms);
					processAnswer(a, q);
					break;
				case 'd':
					a = new Answer(new Date(), 2, q.isCorrect(2), hesitation_ms);
					processAnswer(a, q);
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

	private void processAnswer(Answer a, Question q){
		String fileName = System.getProperty("user.home") + "/answerProto";
		ProtoService ps = new ProtoService(new FileProtoSender(fileName), new PollingFileProtoReceiver(fileName));
		ps.sendAnswer(a);
		
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
		//input.close();
		return c;
	}

}
