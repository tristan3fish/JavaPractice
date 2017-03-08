package com.tristan3fish.revision;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class QuestionFactory {

	private HashMap<String, String> itemsToLearn;
	private HashMap<String, String> itemsToLearnInverted;
	private ArrayList<String> keys;
	private ArrayList<String> values;
	private Random rand;
	
	private HashMap<String, String> fileSamples;
	
	public QuestionFactory(long seed){
		itemsToLearn = new HashMap<String, String>();
		itemsToLearnInverted = new HashMap<String, String>();
		
		fileSamples = new HashMap<String, String>();
		fileSamples.put("CommandSamples", "/Users/tristan/Documents/workspace/RevisionAssistant/src/CommandSamples");
		fileSamples.put("DrivingTheorySamples", "/Users/tristan/Documents/workspace/RevisionAssistant/src/DrivingTheorySamples");
		
		buildDictionaries();
		keys = new ArrayList<>(itemsToLearn.keySet());
		values = new ArrayList<>(itemsToLearnInverted.keySet());
		rand = new Random(seed);
	}
	
	public QuestionFactory(){
		this(System.currentTimeMillis());
	}
	
	public Question buildQuestion(boolean inverceMode){
		String question;
		String answer;
		HashSet<String> wrongAnswers = new HashSet<>();
		
		if(inverceMode){
			question = values.get(rand.nextInt(values.size()-1));
			answer = itemsToLearnInverted.get(question);
			while(wrongAnswers.size()<2){
				String key = values.get(rand.nextInt(values.size()-1));
				wrongAnswers.add(itemsToLearnInverted.get(key));
			}
		}else{
			question = keys.get(rand.nextInt(keys.size()-1));
			answer = itemsToLearn.get(question);
			while(wrongAnswers.size()<2){
				String key = keys.get(rand.nextInt(keys.size()-1));
				wrongAnswers.add(itemsToLearn.get(key));
			}
		}
		
		List<String> posibleAnswers = new ArrayList<String>(wrongAnswers);
		posibleAnswers.add(answer);
		Collections.shuffle(posibleAnswers);//, new Random(System.currentTimeMillis())
		
		return new Question(question, answer, posibleAnswers);
	}
	
	private void buildDictionaries() {

		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(fileSamples.get("CommandSamples")));
			
			String line;
			try {
				while((line = fileReader.readLine()) != null){
					String key = line.split(" ")[0];
					String value = line.substring(key.length(), line.length()).trim();
					itemsToLearn.put(key, value);
					itemsToLearnInverted.put(value, key);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
