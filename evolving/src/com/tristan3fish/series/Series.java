package com.tristan3fish.series;

public interface Series {

	String[] getItemNames();

	int getValue(String item, int t);
	int getValue(int x, int t);

}